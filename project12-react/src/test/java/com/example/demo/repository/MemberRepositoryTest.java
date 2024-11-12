package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository repository;
	
	@Test
	public void 회원가입() {
		
		Member member = Member.builder()
								.id("user3")
								.name("도우너")
								.password("1234")
								.role("ROLE_ADMIN")
								.build();
		
		repository.save(member);
	}
	
	
	@Test
	public void 회원목록조회() {
		List<Member> list = repository.findAll();
		
		for (Member member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	public void 회원수정() {
		
	}
	
	@Test
	public void 회원삭제() {
		repository.deleteById("aa");

	}
}
