package com.example.demo.optional;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 준비(기본세팅)
public class OptionalTest {
	
	// Optional: 값을 감싸고 있는 wrapper 클래스
	// Optional 클래스는 null 값을 안전하게 처리하기 위한 클래스
	// 값의 존재여부에 따라 로직을 처리할 것
	

	@Test // 준비(기본세팅)
	void Optional사용하기() {
		
		String str = "apple";
		
		// of함수: 값을 입력받아서 객체를 생성하는 함수
		Optional<String> opt = Optional.of(str); // 확실히 값이 있을때 of사용
		
		System.out.println("optional에서 값 꺼내기: " + opt.get());
		System.out.println("optional 안에 값이 없는지? " + opt.isEmpty());
		System.out.println("optional 안에 값이 있는지? " + opt.isPresent());
		
		
		// ofNullable함수는 of함수와 달리 빈값도 저장할 수 있음!
		String str2 = null;
//		String str2 = "blueberry";
		
		// str2 값이 있을수도 없을수도 있다.
		Optional<String> opt2 = Optional.ofNullable(str2); 
		// *값이 있는지 없는지 확실하지 않을 때 ofNullable 사용
		
		// 값이 있으면 그대로 사용, 값이 없으면 "바나나"로 대체
		System.out.println(opt2.orElse("바나나(banana)")); // orElse은 조건문 함수
		
	}
	
		@Test
		// 위에 내용 정리
		void of와ofNullable의차이() {
			
			// of: Optional 객체를 생성하는 함수. null 입력불가
			// ofNullable: Optional 객체를 생성하는 함수. null 입력가능
			String str = null;
			Optional<String> opt1 = Optional.of(str); // 에러남
			Optional<String> opt2 = Optional.ofNullable(str);
	}
		
		@Test
		void 빈객체를사용하는경우() {
			
			// Optional 객체를 생성하고 빈값을 저장
			Optional<String> opt = Optional.ofNullable("banana");
			
			// 객체 안에 있는 값 꺼내기
//			System.out.println(opt.get()); // 에러남
			
			// 조건문(if)을 사용하여 null값 체크하기(객체 안에 있는 값 꺼내는 방법)
			if (opt.isPresent() == true) { //  간단하게 줄인 식: if(opt.isPresent()){~~~
				// 객체 안에 있는 값 꺼내기
				System.out.println(opt.get());
			} else {
				System.out.println("값이 없습니다.");
				
				
				// ifPresent함수를 사용하여 빈값 체크하기
				opt.ifPresent(t -> System.out.println(t + "값이 존재합니다"));
			}
		}
		
		// t: value
//		void accept(T t) {
//			System.out.println(t + "값이 존재합니다");
//		}
}






















