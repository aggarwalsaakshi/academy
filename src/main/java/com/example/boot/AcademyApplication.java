package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AcademyApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication();
		 ApplicationContext ctx = springApplication.run(AcademyApplication.class, args);
	}
	
}
