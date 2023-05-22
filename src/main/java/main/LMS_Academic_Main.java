package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = { "academics_mgmt","attendance_mgmt"})
@EntityScan(basePackages ={"academics_mgmt","attendance_mgmt"})
@ComponentScan(basePackages ={"academics_mgmt","attendance_mgmt"})
public class LMS_Academic_Main extends SpringBootServletInitializer  
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LMS_Academic_Main.class);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(LMS_Academic_Main.class, args);
	}
}