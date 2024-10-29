package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz1 {
	
//  1.다음과 같이 강아지(Dog) 클래스를 설계하세요
//  sound 메소드: "왕왕 짖는다" 라는 메세지를 출력
// 2.스프링 컨테이너에 강아지 객체를 저장하세요
// 3.단위테스트 클래스를 작성하세요
//  Dog 타입의 변수를 선언하고, 스프링 컨테이너에서 해당 객체를 주입받으세요
//  주입받은 변수를 사용하여 sound() 메소드를 호출하세요.
	
// * 객체 = 인스턴스 = 빈 * 동일한 말이다
	
	
	
	// "대입하세요", "할당하세요"가 있으면 값을 넣어야 겠지만,
	// 주입이기 때문에 아래에 객체(빈)만 작성해도 됨 
	@Autowired
	Dog dog;
	
	@Test
	void 강아지() {
		System.out.println("객체의 주소값: " + dog);
		dog.sound();
	}
}
