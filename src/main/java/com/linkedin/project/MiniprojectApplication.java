package com.linkedin.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.linkedin.project.service.impl.AuthService;

@SpringBootApplication
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(AuthService authservice) {
		return args ->{
			authservice.createAdmin("admin", "admin", "ROLE_ADMIN");
		};
	}

}
