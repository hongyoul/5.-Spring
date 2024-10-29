package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 회원 정보를 담는 클래스

@Getter // 메소드
@Setter // 메소드
@ToString // 메소드
@NoArgsConstructor // 생성자
@AllArgsConstructor // 생성자
@Builder // 생성자
public class Member {

	int no; // 회원 번호
	
	String userId; // 회원 아이디
	
	String password; // 패스워드
	
}
