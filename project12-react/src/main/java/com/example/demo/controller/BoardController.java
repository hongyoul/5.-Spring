package com.example.demo.controller;

import java.util.List;

import javax.swing.border.Border;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

// @Controller + @ResponseBody = @RestController
// Controller: 해당 클래스를 컨트롤러로 지정
// ResponseBody: 하위 메소드의 응답형식을 json으로 설정
// 응답형식: HTML(JSP, Thymeleaf)파일, JSON(클래스, 리스트, 배열 등)데이터, TEXT(String, int 등)데이터, http(ResponseEntity)응답 메세지 등..
@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	// 새로운 게시물을 등록하는 메소드
	// ResponseEntity: 응답 메세지의 헤더와 바디를 직접설정하는 클래스
	@PostMapping("/register")
	public ResponseEntity<Integer> register(@RequestBody BoardDTO dto){
		
		// 게시물 등록 후 새로운 번호 반환
		int no = service.register(dto);
		
		// 인자ㅣ 데이터, 응답코드
		// 응답코드 201, 데이터는 새로운 게시물번호
		return new ResponseEntity<>(no, HttpStatus.CREATED);
	}

	// 매개변수: URL 파라미터 또는 바디데이터 => 작업에 필요한 데이터
	@GetMapping("/list")
	// ResponseEntity의 타입변수는 바디데이터의 타입
	public ResponseEntity<List<BoardDTO>> getList() {
		
		List<BoardDTO> list = service.getList();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
				// ResponseEntity = 생성자
	}
	
	// 매개변수: 작업에 필요한 데이터
	// 단건조회는 PK가 필요 -> 파라미터 선언
	@GetMapping("/read")
	// 파라미터 형식(
	// 리쿼스트 파람(@RequestParam): /board/read?no=1
	// 파람(Param): /board/read/1)
	public ResponseEntity<BoardDTO> read(@RequestParam(name = "no")int no){
		
		BoardDTO dto = service.read(no);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	// 작업에 필요한 데이터: 수정할 게시물 데이터
	// 데이터가 단순 -> URL 파라미터
	// 데이터가 복잡 -> 메세지 바디
	@PutMapping("/modify")
	public ResponseEntity modify(@RequestBody BoardDTO dto) {
		
		service.modify(dto);
		
		// 처리결과?(void라서 반환 처리가 없음) 와 응답코드
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/remove")
	// 단건삭제 -> 파라미터 필요
	// 예시: localhost:8080/board/remove?no=1
	public ResponseEntity remove(@RequestParam(name = "no") int no) {
		
		service.remove(no);
		
		// 처리 결과: 없음 + 응답코드: 204
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
