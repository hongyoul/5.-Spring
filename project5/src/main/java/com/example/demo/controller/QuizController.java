package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.PersonDTO;

@Controller
@RequestMapping("/quiz")

public class QuizController {

	@GetMapping("/q3") 
	public void q3(Model model) {
		PersonDTO personDTO = new PersonDTO("둘리",20,"인천 구월동");
		
        model.addAttribute("dto", personDTO);
	}
	
	@GetMapping("/q4") 
	public void q4(Model model) {
		
		BookDTO bookDTO = BookDTO.builder()
										.title("스프링부트 웹프로젝트")
										.author("구멍가게코딩단")
										.publicationDate(LocalDate.of(2022, 12, 25))
										.build();
		
		// (변수명, 실제데이터)
		model.addAttribute("dto", bookDTO);
	}
	
	@GetMapping("/q5") 
	public void q5(Model model) {
		
//			배열방법 1번: 값이 정해졌을때 사용
//			int[] arr = new int[10];
			
//			배열 방법 2번
	    	int[] intArr = {1,2,3,4,5,6,7,8,9,10};
	        model.addAttribute("arr", intArr);			
			
		}
		
	 @GetMapping({"/q6", "/q7"})
	    public void ex6(Model model){
	        List<PersonDTO> dtoList = new ArrayList<>();
	        dtoList.add(new PersonDTO("둘리",20,"인천 구월동"));
	        dtoList.add(new PersonDTO("또치",30,"서울 신림동"));
	        dtoList.add(new PersonDTO("도우너",40,"부산 문래동"));
	        model.addAttribute("list", dtoList);
	    }

	 @GetMapping({"/q8", "/q9"})
	    public void ex8(Model model){
	        List<PersonDTO> dtoList = new ArrayList<>();
	        dtoList.add(new PersonDTO("박하나",25,"인천 구월동"));
	        dtoList.add(new PersonDTO("홍재범",17,"서울 신림동"));
	        dtoList.add(new PersonDTO("문유리",31,"부산 문래동"));
	        dtoList.add(new PersonDTO("김재민",8,"인천 연수동"));
	        dtoList.add(new PersonDTO("장유라",33,"부산 문래동"));
	        model.addAttribute("list", dtoList);
	    }
}
