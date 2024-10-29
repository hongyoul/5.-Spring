package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz5 {

	@Autowired
	Hospital hospital;
	
	
	@Autowired
	Doctor doctor;
	
	@Test
	void 객체가생성되었는지확인() {
		System.out.println("hospital: " + hospital);
		System.out.println("doctor: " + doctor);
	}
	
	
	@Test
	void 두객체가같은지확인() {
		System.out.println("doctor: " + doctor);
		System.out.println("hospital의 doctor: " + hospital.doctor);
	}
}
