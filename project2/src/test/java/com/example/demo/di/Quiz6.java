package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quiz6 {

	
	@Autowired
	Teacher teacher;
	// Teacher 타입의 빈을 찾는다.
	// MathTeacher와 ScienceTeacher는 Teacher 인터페이스를 상속받았으므로
	// Teacher 타입의 빈에 해당된다.
	
	
	@Test
	void 테스트() {
		teacher.teach();
	}
}
