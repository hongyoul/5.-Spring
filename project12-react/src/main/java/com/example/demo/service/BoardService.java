package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {

	// 게시물 등록
	int register(BoardDTO dto);
	
	// 게시물 조회
	List<BoardDTO> getList();

	//게시물 단건 조회
	BoardDTO read(int no);

	// 게시물 수정
	void modify(BoardDTO dto);

	// 게시물 삭제
	void remove(int no);

	// 변환 메소드(DTO -> Entity)
	default Board dtoToEntity(BoardDTO dto) {
		
		// 외래키 설정해서 엔티티-writer을 Member클래스 writer로 가공해야됨
		Member member = Member.builder()
				// 주의사항 : 이때 모든 데이터를 입력할 필요가 없음. PK값만 입력할 것
							.id(dto.getWriter())
							.build();

		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member)
				.build();
		return entity;
	}

	// 변환 메소드(Entity -> DTO)
	default BoardDTO entityToDto(Board entity) {
		
		
		// 3. builder 패턴을 사용하여 객체 생성
		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				// 외래키 설정해서 엔티티-writer을 MemberDTO클래스 writer로 가공해야됨
				.writer(entity.getWriter().getId())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
// 변환 메소드 총3가지 방법
	//	1. 디폴드 생성자를 사용하여 객체 생성
	// BoardDTO dto1 = new BoardDTO();
	// dto1.setNo(entity.getNo());
	// dto1.setTitle(entity.getTitle());
	// dto1.setContent(entity.getContent());
	// dto1.setWriter(entity.getWriter());
	// dto1.setRegDate(entity.getRegDate());
	// dto1.setModDate(entity.getModDate());

	//2. All 생성자를 사용하여 객체 생성
	// BoardDTO dto2 = new BoardDTO(entity.getNo(), entity.getTitle, getContent(), getWriter(), getRegDate(), entity.getModDate());
