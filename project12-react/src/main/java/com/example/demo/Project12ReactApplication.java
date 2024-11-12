package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA의 이벤트 리스너를 활성화
@EnableJpaAuditing
@SpringBootApplication
public class Project12ReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project12ReactApplication.class, args);
	}

}
