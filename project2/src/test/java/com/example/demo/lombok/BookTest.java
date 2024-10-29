package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

	@Test
	void 롬복테스트() {
		Book book1 = new Book();
		
		book1.setTitle("직장인의 슬기로운 생활");
		book1.setPrice(25000);
		book1.setPublisher("교보");
		book1.setPage(205);
		
		System.out.println(book1.getTitle());
		System.out.println(book1.getPrice());
		System.out.println(book1.getPublisher());
		System.out.println(book1.getPage());
		
		Book book2 = new Book("자바스크립트", 52200, "한빛", 350);
		
		System.out.println(book2.toString());
		
		Book book3 = Book
				.builder()
				.title("타이타닉")
				.price(35000)
				.publisher("지구")
				.page(450)
				.build();
		
		System.out.println(book3);
		
	}
	
}
