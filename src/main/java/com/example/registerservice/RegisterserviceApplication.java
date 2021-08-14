package com.example.registerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"com.example.registerservice.entity"})
@EnableJpaRepositories({"com.example.registerservice.repo"})
@ComponentScan({"com.example.registerservice.controller", "com.example.registerservice.service"})
@Configuration
@SpringBootApplication  
public class RegisterserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterserviceApplication.class, args);
	}

}
