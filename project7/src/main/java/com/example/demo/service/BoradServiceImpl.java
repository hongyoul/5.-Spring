package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

// 자식 클래스들 중 서비스로 지정
@Service

// Service의 목적
//1. 비즈니스 로직 처리 
//예: 회원가입 => 
//			아이디:
//				 첫번째 방식: 아이디 10글자 이내
//				 두번째 방식: 아이디 8글자 이내 + 대문자 포함
//				 
//2. 데이타 가공

public class BoradServiceImpl implements BoardService{
	
	@Autowired
	BoardRepository repository; // 리파지토리를 빈으로 주입(선언)

	@Override
	public int register(BoardDTO dto) {
		
		// 전달받은 DTO를 엔티티로 변환
		Board entity = dtoToEntity(dto);
		
		// 엔티티를 테이블에 저장
		repository.save(entity);
		
		// 저장 후 게시물의 번호를 반환
		int newNo = entity.getNo();
		
		 System.out.println(entity);
		
		return newNo;
		
	}
	
//	1번 @Override
//	public List<BoardDTO> getList() {
		// 데이터베이스에서 게시물 목록 가져오기
//			List<Board> result = repository.findAll();
//		
//		// 엔티티 리스트를 DTO 리스트로 변환하기
//			List<BoardDTO> list = new ArrayList<>();
//			
//		// 리스트에서 스트림 생성하기
//		// 스트림을 사용하여 모든 엔티티를 DTO로 변환
//		// 함수형 인터페이스는 암다식 함수로 구현한다.
//			list = result.stream()
//				  .map(entity -> entityToDto(entity))
//				  .collect(Collectors.toList());
//			
//			return list; //변환한 DTO 리스트 변환
//	}
	
	// 람다식 중간 식
//	R apply(T entity) {
//		return entityToDto(entity); }

	
	//	2번
	@Override
	public Page<BoardDTO> getList(int pageNumber) {
		
		
		// 페이지번호를 인덱스로 변경
		// 페이지 번호에서 1만큼 빼야함
		int pageNum = (pageNumber == 0) ? 0 : pageNumber -1;
		
		// 정렬 조건
		Sort sort = Sort.by("no").descending();
		
		// 페이지 조건
		Pageable pageable = PageRequest.of(pageNum, 10, sort);
		
		Page<Board> page = repository.findAll(pageable);
		
		// 엔티티 리스트 -> DTO 리스트로 변환
		
		Page<BoardDTO> dtoPage = page
									.map(entity -> entityToDto(entity));
		
		// 변환한 DTO 타입의 page 객체 변환
		return dtoPage;
		
	}


	
	@Override
	public BoardDTO read(int no) {
		
		// 게시물 번호로 글 조회
		Optional<Board> optional = repository.findById(no);
		
		// 값이 있는지 확인
		if (optional.isPresent()) {
			Board board = optional.get();
			BoardDTO dto = entityToDto(board);
			return dto;
		}
		
		return null;
	}

	@Override
	public void modify(BoardDTO dto) {
		
		// 전달받은 DTO에서 게시물 번호를 꺼내고, DB에 존재하는지 확인
		int no = dto.getNo();
		
		Optional<Board> optional = repository.findById(no);
		
		if (optional.isPresent()) {
			
			Board board = optional.get();
			
			
			// 기존 엔티티에서 제목, 내용, 작성자 변경
			board.setTitle(dto.getTitle());
			board.setContent(dto.getContent());
			board.setWriter(dto.getWriter());
			
			// 데이터베이스에 업데이트
			repository.save(board);
		}
		
	}

	@Override
	public void remove(int no) {
		
		// 게시물이 존재하는 확인하고 삭제
		Optional<Board> optional = repository.findById(no);
		
		if(optional.isPresent()) {
			repository.deleteById(no);
		}
		
	}

	
}