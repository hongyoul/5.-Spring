package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	MemberService service;
	
	@Test
	public void 목록조회() {
		List<MemberDTO> list = service.getList();
		
		for (MemberDTO memberDTO : list) {
			System.out.println(memberDTO);
		}
	}
		
	@Test
	public void 상세조회() {
		// 조건 : 아이디
		MemberDTO dto = service.read("user1");
		
		System.out.println(dto);
	}
	
	@Test
	public void 회원가입() {
		
		MemberDTO dto = MemberDTO.builder()
								  .id("user1")
								  .password("1234")
								  .name("고길동")
								  .role("ROLE_ADMIN")
								  .build();
		
		service.register(dto);
	}
	
	@Test
	public void 게시물삭제() {

	}

}
