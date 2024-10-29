package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")

public class SampleQuiz {

	
	// model: 뷰에 데이터를  전달하는 객체
	// void: URL 경로에 따라 HTML 파일 반환
	
	@GetMapping("/q1") 
	public void q1(Model model) {
		model.addAttribute("msg1","둘리");
		model.addAttribute("msg2","20");
		model.addAttribute("msg3","인천 구월동");
	}
	
	@GetMapping("/q2") 
	public void q2(Model model) {
		model.addAttribute("msg4","스프링부트웹프로젝트");
		model.addAttribute("msg5","구멍가게 코딩단");
		
		model.addAttribute("msg6","2022.12.25");
		model.addAttribute("msg7", LocalDate.of(2022,12,25));
	}
	
	
	
	
}
