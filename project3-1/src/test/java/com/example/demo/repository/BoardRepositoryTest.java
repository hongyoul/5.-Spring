package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;



@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 리파지토리_객체를_가져왔는지_확인() {
		System.out.println("boardRepository = " + boardRepository); //  객체의 메모리 주소 값이 나옴
	}
	
	// '나는 구현체를 만든적이 없는데?' '나는 빈(객체)을 등록한 적이 없는데?' 라는 의문이 생김
	// 	=> jpa가 자동으로 구현체를 만들고 빈을 자동으로 생성했기 때문에 나오는 것임
	
	@Test
	public void 데이터등록() {
		// 생성자를 사용하여 객체 생성
		Board board1 = new Board(0, "1번글", "내용", null, null);
		
		boardRepository.save(board1);
		
		//builder를 사용하여 객체 생성
		Board board2 = Board
							.builder()
							.title("2번글")
							.content("내용~")
							.build();
		
		
		boardRepository.save(board2);
		// save 함수를 호출하면 insert 또는  update 쿼리가 생성됨
	}
	
	@Test
	public void 데이터전체조회() {
		
		List<Board> list = boardRepository.findAll();
		
		// findAll 함수를 호출하면 select 쿼리가 생성됨
		
		for (Board board : list) {
			
			System.out.println(board);
			
		}
	}
	
	@Test
	public void 데이터단건조회() {
		
		Optional<Board> optional = boardRepository.findById(2);
		
//		System.out.println(optional); 
//		System.out.println(optional.get()); 바로 꺼내면 안됨

		// optional 안에 값이 있는지 확인하고 꺼내기
		if (optional.isPresent() == true) {
			Board board = optional.get();
			System.out.println(board);
		}
	}
	
	@Test
	public void 데이터수정() {
		
		//데이터가 존재하는지 확인
		Optional<Board> result = boardRepository.findById(1);
		Board border = result.get();
		
		// 데이터 일부 변경
		border.setContent("내용이 수정되었습니다.");
		
		// 게시물
		boardRepository.save(border);
	}
	
	
}
