package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//서블릿 등록
@ServletComponentScan
@SpringBootApplication
public class Project41Application {

	public static void main(String[] args) {
		SpringApplication.run(Project41Application.class, args);
	}

}
