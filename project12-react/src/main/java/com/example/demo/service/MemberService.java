package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

public interface MemberService {
	
	// 회원 목록 조회
	List<MemberDTO> getList();
	
	// 회원 등록
	boolean register(MemberDTO dto);

	// 회원 단건 조회
	MemberDTO read(String id);
	
	// 변환 메소드(Entity -> DTO)
	default MemberDTO entityToDto(Member entity) {
		
		MemberDTO dto = MemberDTO.builder()
				.id(entity.getId())
				.password(entity.getPassword())
				.name(entity.getName())
				.role(entity.getRole())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}
	
	// 변환 메소드(DTO -> Entity)
	default Member dtoToEntity(MemberDTO dto) {
		
		Member entity = Member.builder()
				.id(dto.getId())
				.password(dto.getPassword())
				.name(dto.getName())
				.role(dto.getRole())
				.build();
		
		return entity;
	}

}
