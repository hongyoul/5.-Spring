package com.example.demo.controller;

import java.io.IOException;
import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ParamController1 {

	@ResponseBody
	@GetMapping("/header1")
	public String method1(HttpServletRequest request,
						  HttpServletResponse response,
						  HttpMethod httpMethod,
						  Locale locale,
						  @RequestHeader("host") String host
						  ) {
		
		
		System.out.println("request =" + request); // 요청 메세지
		System.out.println("response =" + response); // 응답 메세지
		System.out.println("httpMethod =" + httpMethod); // HTTP 메소드
		System.out.println("locale =" + locale); // 국가
		
		return "ok";
	}
	
	
	@ResponseBody
	@GetMapping("/header2")
	public void method2 (HttpServletRequest request,
						 HttpServletResponse response) throws IOException {
		
		//request 객체를 사용하여 요청메세지에 담긴 파라미터 꺼내기
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("username" + username);
		System.out.println("age" + age);
		
		// response 객체를 사용하여 응답메세지에 데이터 담기
		response.getWriter().write("ok");
	}
}
