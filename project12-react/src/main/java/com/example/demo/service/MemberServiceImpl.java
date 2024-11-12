package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

//@Service // 빈 등록
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;

	@Override
	public List<MemberDTO> getList() {
		
		List<Member> entityList = repository.findAll();		
		
		// 스트림을 사용하여 변환
		List<MemberDTO> dtoList = entityList.stream()
								.map(entity -> entityToDto(entity))
								.collect(Collectors.toList());

		// 변환한 리스트 반환
		return dtoList;
	}
	
	
	@Override
	public MemberDTO read(String id) {
		
		Optional<Member> result = repository.findById(id);
		
		if (result.isPresent()) {
			Member member = result.get();
			// Entity -> DTO
			// MemberDTO dto = entityToDto(member);
			return entityToDto(member);
		} else {
			return null;
		}
	}
	
	@Override
	public boolean register(MemberDTO dto) {
		
		// 등록시 주의사항: PK가 중복되면 안됨
		// NO는 자동으로 발급되어 중복될 일이 없음
		// 하지만 아이디는 사용자가 직접 입력하기 때문에 중복체크를 별도로 해야됨

		// 회원아이디가 사용중인지 체크
		String id = dto.getId();
		
		MemberDTO getDto = read(id);
		
		// 
		if (getDto != null) {
			System.out.println("해당 아이디는 사용중인 아이디입니다.");
			return false; // 여기서 회원가입 종료
		} else {
			// 데이터가 DB에 없는경우
			// DTO -> Entity
			Member entity = dtoToEntity(dto);
			repository.save(entity);
			return true;
		}
		
	}

}
