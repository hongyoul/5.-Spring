package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;


@SpringBootTest
public class BoardServiceTest {

	@Autowired
	BoardService service;
	
	@Test
	public void 게시물추가() {
		BoardDTO dto = BoardDTO.builder()
								.title("5번")
								.content("안녕하세요")
								.writer("둘리")
								.build();
//		게시물 추가
		int newno = service.register(dto);
		System.out.println("새로운 게시물 번호: " + newno);
	}

	@Test
	public void 게시물30개추가() {
		
	}
	
	@Test
	public void 게시물목록조회() {
		// 서비스를 사용하여 게시물 목록을 조회하는 코드
		List<BoardDTO> list = service.getList();
		
		for (BoardDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 게시물단건조회() {
		// 단건 조회
			BoardDTO dto = service.read(3);
			
			System.out.println(dto);
		}
	
	@Test
	public void 게시물수정() {

		BoardDTO dto = service.read(6);
			dto.setContent("수정_안녕하세요");
			dto.setTitle("4번");
			service.modify(dto);
	}
	
	@Test
	public void 게시물삭제() {
//		단건 삭제 : 조건 필요: no
		service.remove(7);
	}

}
