package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

	// 스프링 컨테이너에 등록한 빈에게 의존관계주입이 필요할 때, DI(의존성 주입)을 도와주는 어노테이션
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 빈확인() {
		System.out.println("boardRepository: "+ boardRepository);
	}
	
	@Test
	public void 게시물등록() {
		
		Board board = Board.builder()
							.title("3번")
							.content("안녕하세요")
//							.writer("둘리")
							.build();
		
		// save: insert 또는 update 기능이 실행됨
		boardRepository.save(board);
	}
	
	
	@Test
	public void 목록조회() {
		List<Board> list = boardRepository.findAll();
		
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	public void 상세조회() {
		// 상세조회(단건조회)
		Optional<Board> optional = boardRepository.findById(1);

		// optional 안에 값이 있다면
		if (optional.isPresent() == true) {
			
			Board board = optional.get();
			
			System.out.println(board);
		}
		
	}
	
	@Test
	public void 수정() {
		Optional<Board> optional = boardRepository.findById(2);
		
		if (optional.isPresent()) {
			
			Board board = optional.get();
			board.setContent("2번");
			
			// save() -> update 쿼리 실행
			boardRepository.save(board);
			// 테이블에 no가 없으면 insert
			// 있으면 update
		}
		
	}
	
	@Test
	public void 삭제() {
		Optional<Board> optional = boardRepository.findById(2);

		if (optional.isPresent()) {
			boardRepository.deleteById(3);
		}
		
	}
	
	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll();
	}
}
