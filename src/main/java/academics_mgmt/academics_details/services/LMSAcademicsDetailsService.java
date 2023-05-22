package academics_mgmt.academics_details.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import academics_mgmt.academics_details.model.dto.LMSAcademicsDetailsDTO;
import academics_mgmt.academics_details.model.dto.LMSBatchMasterDTO;
import academics_mgmt.academics_details.model.dto.LMSCourseMasterDTO;
import academics_mgmt.academics_details.model.dto.LMSSessionMasterDTO;
import academics_mgmt.academics_details.model.dto.SchedulerDetailDTO;
import academics_mgmt.academics_details.model.dto.SchedulerMasterDTO;
import academics_mgmt.academics_details.model.master.LMSAcademicsDetails;
import academics_mgmt.academics_details.model.repo.LMSAcademicsDetailsRepo;
import academics_mgmt.academics_master.model.master.LMSAcademicsMaster;
import academics_mgmt.academics_master.model.repo.LMSAcademicsMasterRepo;
import academics_mgmt.academics_master.services.LMSAcademicsMasterService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("lmsAcademicsDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSAcademicsDetailsService implements I_LMSAcademicsDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(LMSAcademicsDetailsService.class);

	@Autowired
	private LMSAcademicsMasterRepo lmsAcademicsMasterRepo;

	@Autowired
	private LMSAcademicsMasterService lmsAcademicsMasterServ;
	
	@Autowired
	private WebClient webClient;

	@Autowired
	private LMSAcademicsDetailsRepo lmsAcademicsDetailsRepo;

	@Override
	public ArrayList<LMSAcademicsDetailsDTO> getAllSessions() {
		ArrayList<LMSAcademicsDetailsDTO> courseMasterDTOs = new ArrayList<LMSAcademicsDetailsDTO>();
		ArrayList<LMSAcademicsDetails> courseMasterOpts = (ArrayList<LMSAcademicsDetails>) lmsAcademicsDetailsRepo
				.findAll();

		if (courseMasterOpts != null) {
			courseMasterDTOs = getAcademicsDetailsDtos(courseMasterOpts);
		} else {
			courseMasterDTOs = null;
		}

		return courseMasterDTOs;
	}

	@Override
	public ArrayList<LMSAcademicsDetailsDTO> getSelectSessions(ArrayList<Long> ids) {
		ArrayList<LMSAcademicsDetails> lMasters = lmsAcademicsDetailsRepo.getSelectSessions(ids);
		ArrayList<LMSAcademicsDetailsDTO> LMSAcademicsDetailsDTOs = new ArrayList<LMSAcademicsDetailsDTO>();

		if (lMasters != null) {
			LMSAcademicsDetailsDTOs = getAcademicsDetailsDtos(lMasters);
		}

		return LMSAcademicsDetailsDTOs;
	}

	@Scheduled(fixedRate = 20000)
		public void new_ScheduleFromScheduler() {
		logger.info("starting scheduler");
		ArrayList<LMSAcademicsMaster> academicsMasters = lmsAcademicsMasterRepo.getSelectAcademicMastersNotAllocated();
		SchedulerMasterDTO schdDTO = new SchedulerMasterDTO();
		Long iSeqNo = (long) 0;
		Long rSeqNo = (long) 0;
		Long sSeqNo = (long) 0;
		Long subSeqNo = (long) 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		if (academicsMasters != null) {
			for (int i = 0; i < academicsMasters.size(); i++) {
				subSeqNo = academicsMasters.get(i).getId().getSubjectSeqNo();
				sSeqNo = academicsMasters.get(i).getId().getSessionSeqNo();
				rSeqNo = academicsMasters.get(i).getId().getRuleSeqNo();
				schdDTO = new SchedulerMasterDTO();
				iSeqNo = this.getInstitution(academicsMasters.get(i).getId().getSessionSeqNo());
				schdDTO.setFromDttm(formatter.format(academicsMasters.get(i).getFromDttm().toLocalDateTime()));
				schdDTO.setToDttm(formatter.format(academicsMasters.get(i).getToDttm().toLocalDateTime()));
				schdDTO.setCompanySeqNo(iSeqNo);
				schdDTO.setTargetSeqNo(sSeqNo);
				schdDTO.setRuleSeqNo(rSeqNo);
				schdDTO.setScheduleData(academicsMasters.get(i).getScheduleData());
				schdDTO.setJobTypeSeqNo(academicsMasters.get(i).getJobTypeSeqNo());
				schdDTO.setScheduledFlag('n');
				schdDTO.setFrtm(academicsMasters.get(i).getTimeFr());
				schdDTO.setTotm(academicsMasters.get(i).getTimeTo());

				Mono<SchedulerMasterDTO> schedDTO1 = webClient.post().uri("/schedulerManagement/new")
						.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
						.body(Mono.just(schdDTO), SchedulerMasterDTO.class).retrieve()
						.bodyToMono(SchedulerMasterDTO.class);
				SchedulerMasterDTO specDTO3 = schedDTO1.block();
				lmsAcademicsMasterRepo.updRuleLine(sSeqNo, rSeqNo, subSeqNo, specDTO3.getRuleLineSeqNo());
				lmsAcademicsMasterRepo.updStatus(sSeqNo, rSeqNo, subSeqNo);
			}
		}
		logger.info("stopping scheduler");
	}

	@Scheduled(fixedRate = 20000)	
	public void newAcademicInstances() 
	{
		logger.info("starting detailer");
		ArrayList<LMSAcademicsMaster> academicsMasters = lmsAcademicsMasterRepo.getSelectAcademicMastersNotDetailed();
		Long rSeqNo = (long) 0;
		Long ruleSeqNo = (long) 0;
		Long subSeqNo = (long) 0;
		Long sSeqNo = (long) 0;		
		String frDtTime = null;
		String toDtTime = null;
		LMSAcademicsDetailsDTO lms_AcademicsDetailsDTO = null;
		
		if (academicsMasters != null && academicsMasters.size() > 0) 
		{
			logger.info("found masters");
			for (int i = 0; i < academicsMasters.size(); i++) 
			{
				subSeqNo = academicsMasters.get(i).getId().getSubjectSeqNo();
				ruleSeqNo= academicsMasters.get(i).getId().getRuleSeqNo();
				sSeqNo = academicsMasters.get(i).getId().getSessionSeqNo();
				rSeqNo = academicsMasters.get(i).getRuleLineSeqNo();
				logger.info("session :"+sSeqNo);
				logger.info("subject :"+subSeqNo);
				logger.info("rule line :"+rSeqNo);
				this.delForSessionAndSubject(sSeqNo, subSeqNo);
				
				Flux<SchedulerDetailDTO> lmsScheduleDetailsDTOs = webClient.method(HttpMethod.GET)
						.uri("/schedulerManagement/getSelectSchedulesForRuleLine")
						.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
						.body(Mono.just(rSeqNo), Long.class).retrieve().bodyToFlux(SchedulerDetailDTO.class);
				ArrayList<SchedulerDetailDTO> ruleLineDetailDTOs = (ArrayList<SchedulerDetailDTO>) lmsScheduleDetailsDTOs
						.collectList().block();

				if (ruleLineDetailDTOs != null && ruleLineDetailDTOs.size() > 0) 
				{
					for (int j = 0; j < ruleLineDetailDTOs.size(); j++) 
					{
						lms_AcademicsDetailsDTO = new LMSAcademicsDetailsDTO();
						frDtTime = ruleLineDetailDTOs.get(j).getFrDttm();
						toDtTime = ruleLineDetailDTOs.get(j).getToDttm();
						lms_AcademicsDetailsDTO.setFrDtTm(frDtTime);
						lms_AcademicsDetailsDTO.setToDtTm(toDtTime);
						lms_AcademicsDetailsDTO.setSessionSeqNo(sSeqNo);
						lms_AcademicsDetailsDTO.setSubjectSeqNo(subSeqNo);
						lmsAcademicsDetailsRepo.save(this.setAcademicsDetails(lms_AcademicsDetailsDTO));
					}
					lmsAcademicsMasterServ.updDetailedStatus(sSeqNo, ruleSeqNo, subSeqNo);
				}
			}
		}
		logger.info("stopping detailer");
	}

	private Long getInstitution(Long sSeqNo) {
		Long bSeqNo = (long) 0;
		Long cSeqNo = (long) 0;
		Long iSeqNo = (long) 0;
		ArrayList<Long> lmsSessions = new ArrayList<Long>();
		ArrayList<Long> lmsBatches = new ArrayList<Long>();
		ArrayList<Long> lmsCourses = new ArrayList<Long>();
		lmsSessions.add(sSeqNo);

		Flux<LMSSessionMasterDTO> lmsSessionMasterDTO = webClient.method(HttpMethod.GET)
				.uri("/sessionManagement/getSelectSessions")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Flux.fromIterable(lmsSessions), Long.class).retrieve().bodyToFlux(LMSSessionMasterDTO.class);
		ArrayList<LMSSessionMasterDTO> sessionMasterDTOs = (ArrayList<LMSSessionMasterDTO>) lmsSessionMasterDTO
				.collectList().block();
		bSeqNo = sessionMasterDTOs.get(0).getBatchSeqNo();
		logger.info("Batch Found :" + bSeqNo);
		lmsBatches.add(bSeqNo);

		Flux<LMSBatchMasterDTO> lmsBatchMasterDTO = webClient.method(HttpMethod.GET)
				.uri("/batchManagement/getSelectBatches")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Flux.fromIterable(lmsBatches), Long.class).retrieve().bodyToFlux(LMSBatchMasterDTO.class);
		ArrayList<LMSBatchMasterDTO> batchMasterDTOs = (ArrayList<LMSBatchMasterDTO>) lmsBatchMasterDTO.collectList()
				.block();
		cSeqNo = batchMasterDTOs.get(0).getCourseSeqNo();
		logger.info("Course Found :" + cSeqNo);
		lmsCourses.add(cSeqNo);

		Flux<LMSCourseMasterDTO> lmsCourseDTO = webClient.method(HttpMethod.GET)
				.uri("/courseManagement/getSelectCourses")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Flux.fromIterable(lmsCourses), Long.class).retrieve().bodyToFlux(LMSCourseMasterDTO.class);
		ArrayList<LMSCourseMasterDTO> courseMasterDTOs = (ArrayList<LMSCourseMasterDTO>) lmsCourseDTO.collectList()
				.block();
		iSeqNo = courseMasterDTOs.get(0).getInstituteSeqNo();
		logger.info("Inst Found :" + iSeqNo);
		return iSeqNo;
	}

	public LMSAcademicsDetailsDTO newLMSAcademicsDetails(LMSAcademicsDetailsDTO lms_AcademicsDetailsDTO) {
		LMSAcademicsDetails lms_AcademicsDetails = lmsAcademicsDetailsRepo
				.save(setAcademicsDetails(lms_AcademicsDetailsDTO));
		LMSAcademicsDetailsDTO courseMasterDTO2 = getAcademicsDetailsDto(lms_AcademicsDetails);
		return courseMasterDTO2;
	}

	public void updLMSAcademicsDetails(LMSAcademicsDetailsDTO lMSAcademicsDetailsDTO) {
		LMSAcademicsDetails lms_AcademicsDetails = setAcademicsDetails(lMSAcademicsDetailsDTO);
		lmsAcademicsDetailsRepo.save(lms_AcademicsDetails);
	}

	public void delSelectSessions(ArrayList<Long> DocumentSeqNos) {
		lmsAcademicsDetailsRepo.delSelectSessions(DocumentSeqNos);
	}

	public void delAllLMSAcademicsDetails() {
		lmsAcademicsDetailsRepo.deleteAll();
	}
	
	public void delForSessionAndSubject(Long sSeqNo, Long subSeqNo) 
	{
		lmsAcademicsDetailsRepo.delForSessionAndSubject(sSeqNo, subSeqNo);
	}


	private ArrayList<LMSAcademicsDetailsDTO> getAcademicsDetailsDtos(
			ArrayList<LMSAcademicsDetails> lms_AcademicsDetails) {
		LMSAcademicsDetailsDTO courseMasterDTO = null;
		ArrayList<LMSAcademicsDetailsDTO> courseMasterDTOs = new ArrayList<LMSAcademicsDetailsDTO>();

		for (int i = 0; i < lms_AcademicsDetails.size(); i++) {
			courseMasterDTO = getAcademicsDetailsDto(lms_AcademicsDetails.get(i));
			courseMasterDTOs.add(courseMasterDTO);
		}
		return courseMasterDTOs;
	}

	private LMSAcademicsDetailsDTO getAcademicsDetailsDto(LMSAcademicsDetails sMaster) {
		LMSAcademicsDetailsDTO lDTO = new LMSAcademicsDetailsDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		lDTO.setFrDtTm(formatter.format(sMaster.getFrDtTm().toLocalDateTime()));
		lDTO.setToDtTm(formatter.format(sMaster.getToDtTm().toLocalDateTime()));
		lDTO.setActionInstanceSeqNo(sMaster.getActionInstanceSeqNo());
		lDTO.setSessionSeqNo(sMaster.getSessionSeqNo());
		lDTO.setSubjectSeqNo(sMaster.getSubjectSeqNo());
		return lDTO;
	}

	private LMSAcademicsDetails setAcademicsDetails(LMSAcademicsDetailsDTO sMasterDTO) {
		LMSAcademicsDetails lms_AcademicsDetails = new LMSAcademicsDetails();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(sMasterDTO.getFrDtTm(), formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(sMasterDTO.getToDtTm(), formatter);
		lms_AcademicsDetails.setFrDtTm(Timestamp.valueOf(frDateTime));
		lms_AcademicsDetails.setToDtTm(Timestamp.valueOf(toDateTime));
		lms_AcademicsDetails.setSessionSeqNo(sMasterDTO.getSessionSeqNo());
		lms_AcademicsDetails.setSubjectSeqNo(sMasterDTO.getSubjectSeqNo());
		return lms_AcademicsDetails;
	}

}