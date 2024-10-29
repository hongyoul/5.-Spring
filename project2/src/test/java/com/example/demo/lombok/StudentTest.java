package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

	@Test
	void 롬복테스트() {
		Student student1 = new Student();
		
		student1.setNumber(1001);
		student1.setName("홍길동");
		student1.setAge(21);
		
		System.out.println(student1.getNumber());
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		
		Student student2 = new Student(1002, "김동준", 25);
		
		System.out.println(student2.toString());
		
		Student student3 = Student
				.builder()
				.number(1003)
				.name("셀리나 자바")
				.age(23)
				.build();
		
		System.out.println(student3);
		
	}
	
}



