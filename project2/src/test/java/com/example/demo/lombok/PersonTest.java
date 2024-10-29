package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//  테스트 클래스 만들전 선작업
@SpringBootTest // 스프링 컨테이너 환경

public class PersonTest {

	@Test // 단위 테스트(= 메소드를 만들고 @Test를 넣어준다)
	void 롬복테스트() {
		
		Person person1 = new Person(); //디폴트 생성자
		
		person1.setName("둘리"); // setter
		person1.setAge(12);
		
		System.out.println(person1.getName()); // getter
		System.out.println(person1.getAge()); 
		
		
		// 모든 멤버를 입력받는 생성자
		Person person2 = new Person("또치", 15);
		// 재정의 된 ToString
		System.out.println(person2.toString());
		
		// Builder : 메소드 체인 패턴으로 객체를 생성하는 생성자
		// 값을 선택하여 입력할 수 있음
		Person person3 = Person
				.builder() // 준비
				.name("도우너") // 필드
				.age(17) // 필드
				.build(); // 객체생성
		
		System.out.println(person3);
	}
}
