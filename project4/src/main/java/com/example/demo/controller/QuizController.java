package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //해당 클래스를 컨트롤러로 지정하고, 빈으로 등록
@RequestMapping("/quiz")

public class QuizController {
	
//	MemberRepository repository = new MemberRepository();
//	
//	// 회원 폼을 반환하는 메소드
//	   @GetMapping("/form") 
//	    public String method1() {
//	        return "/quiz/form"; 
//	    
//	        
//	   }
//	   
//	   
//	// 회원 등록을 처리하는 메소드
//	   @PostMapping("/save") 
//	    public String method2(@RequestParam(name = "username") String username, 
//	    						@RequestParam(name = "password") String password,
//	    						Model model) { 
//		   
//		   // 새로운 회원 객체 생성 후 저장소에 저장
//	        Member member = new Member(0, username, password);
//	        repository.save(member);
//	        
//	        // 추가된 회원 정보를 모델에 담아 JSP로 전달
//	        model.addAttribute("member", member); // ("데이터의 이름", 실제 데이터)
//		   
//		   return "/quiz/save";
//	   }
	
	
	@GetMapping("/q1") 
    public String method1() {
        return "/quiz/q1"; 
   }
        
     
     @GetMapping("/q2") 
     public String method2() {
        return "/quiz/q2"; 
     }     
    
        
   
   
}
