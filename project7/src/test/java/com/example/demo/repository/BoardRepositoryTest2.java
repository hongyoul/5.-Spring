package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest2 {

	
	@Autowired
	BoardRepository repository;
	
	@Test
	public void 데스트용게시물30개추가() {
		
		for (int i = 0; i < 30; i++) {
			
			Board board = Board.builder()
									.title(i + "번글")
									.content("안녕하세요" + i +"번글 입니다")
									.writer(i + "번째 둘리")
									.build();
			
			repository.save(board);
			
		}
		
	}
	
	@Test
	public void 페이징테스트() {
		
		// 1번 페이징 게시물 10건 설정
		// Pageble: 페이징 처리 조건
		Pageable pageble = PageRequest.of(0, 10);
		
		// 페이징 조건을 사용하여 목록 조회
		// Page : 게시물 목록 + 페이지 정보
		Page<Board> result = repository.findAll(pageble);
		
		// 전체 페이지 정보 출력
		System.out.println(result);
		
		
		// 게시물 리스트만 출력
		List<Board> list = result.getContent();
		System.out.println(list);
	}
	
	
	@Test
	public void 정렬조건추가하기() {
		
		// no 필드를 기준으로 내림차순으로 정렬
		Sort sort = Sort.by("no").descending(); // by("no")은 DTO의 어떤거든 상관없다. title, content 등 다 가능
		
		// 페이지번호, 데이터 개수, 정렬 조건
		Pageable pageable = PageRequest.of(2, 10, sort);
		
		Page<Board> result = repository.findAll(pageable);
		
		List<Board> list = result.getContent();
		
		for (Board board : list) {
			
			System.out.println(board);
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}