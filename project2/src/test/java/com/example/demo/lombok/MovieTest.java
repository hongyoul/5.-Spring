package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieTest {

	@Test
	void 롬복테스트() {
		Movie movie1 = new Movie();
		
		movie1.setTitle("타짜");
		movie1.setSupervision("홍길동");
		movie1.setReleaseDate("2024.09.10");
		
		System.out.println(movie1.getTitle());
		System.out.println(movie1.getSupervision());
		System.out.println(movie1.getReleaseDate());
		
		Movie movie2 = new Movie("지진", "김동준", "2025.8.25");
		
		System.out.println(movie2.toString());
		
		Movie movie3 = Movie
				.builder()
				.title("디지니공주들")
				.supervision("셀리나 자바")
				.releaseDate("2025.1.25")
				.build();
		
		System.out.println(movie3);
		
	}
	
}
