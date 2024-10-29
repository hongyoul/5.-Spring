package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


// 응답의 형태가 여러가지기 때문에 @ResponseBody를 쓰면 안됨
@Controller
public class ReturnController1 {

	// 메소드의 리턴타입에 따라 반환할 데이터의 형식이 설정됨
	// ModelAndView: 데이터와 화면경로를 설정하는 객체
	@GetMapping("/return/ex1")
	public ModelAndView ex1() {
		ModelAndView modelAndView = new ModelAndView("return/sample") //파일경로
													.addObject("date", "banana");
			return modelAndView;							
	}
	
	//Model: 화면에 데이터를 전달하는 객체
	// 리턴타입으로 String을 쓰면 파일의 경로를 직접설정
	@GetMapping("/return/ex2")
	public String ex2(Model model) {
		model.addAttribute("date", "banana"); //데이터 전달
		return "return/sample"; // HTML 파일의 경로
	}
	
	// 리턴 타입을 void로 쓰면 URL경로가 파일의 경로가 됨
	@GetMapping("return/sample")
	public void ex3(Model model) {
		model.addAttribute("date", "banana"); 
	}
	//모든 메소드가 같은 결과를 반환함
	
}
