package com.capsule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.capsule.dao")
@EntityScan("com.capsule.entity")
@ComponentScan({"com.capsule.controller","com.capsule.service", "com.capsule.filter"})
public class CapsuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapsuleApiApplication.class, args);
	}

}