package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/param")

// 모든 메소드가 JSON 형식으로 응답을 반환함
@ResponseBody // 공통으로 들어가기 때문에 위에 공통으로 따로 뺌
public class QuizController {
	
	
	
	@GetMapping("/q1")
	public String q1(@RequestParam(name = "i") String i) {
		
		System.out.println("String타입 파라미터 수집: " + i);
		
		return "ok";
	}
	
	
	
	@GetMapping("/q2")
	public String q2(@RequestParam(name = "f") Float f,
					 @RequestParam(name = "b") Boolean b) {
		System.out.print("Float타입 파라미터 수집:" + f + ", ");
		System.out.println("Boolean 타입 파라미터 수집:" + b);
		
		return "ok";
	}
	
	
	@GetMapping("/q3")
	// ?arr=a&arr=b&arr=c
	public String q3(@RequestParam(name = "arr") char[] arr) {
		
		System.out.println("char 형 배열 수집: " + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("배열의 개수: " + arr.length);
		
		return "ok";
	}
	
	// 4,5,6번 : 복잡한 파라미터는 메세지 바디에 데이터를 담을 것
	//@RequestBody 사용하여 JSON형식의 문자열을 클래스로 변환
	
	@PostMapping("/q4")
	
	// body->row->JSON으로 들어가서 '{ "no" : 1, "name" : "둘리", "grade": 3}' 작성
	public String q4(@RequestBody StudentDTO studentDTO) {
		
		System.out.println("객체수집: " + studentDTO);
		
		return "ok";
	}
	
	
	// JSON에서 객체는 {} 리스트는[]로 작성
	@PostMapping("/q5")
	public String q5(@RequestBody ArrayList<StudentDTO> list) {
		
		System.out.println("객체 리스트 수집: " + list);
		
		for (StudentDTO studentDTO : list) {
			System.out.println(studentDTO);
		}
		
		System.out.println("리스트 개수: " + list.size());
		
		return "ok";
	}
	
	

	@PostMapping("/q6")
	public String q6(@RequestBody ArrayList<CarDTO> carDTOs) {
		
		System.out.println("객체 리스트 수집: " + carDTOs);
		
		for (CarDTO carDTO : carDTOs) {
			System.out.println(carDTO);
		}
		
		// 마지막요소의 인덱스를 구해야함
		// 리스트 전체 크기
		
		int size = carDTOs.size(); // 사이즈는 속성이 아니기 때문에 선언을 해줘야함
		System.out.println("리스트 마지막 요소: " + carDTOs.get(size-1));
		
		return "ok";
	}
	
}

