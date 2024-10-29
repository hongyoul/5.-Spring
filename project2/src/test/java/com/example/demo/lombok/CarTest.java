package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTest {
	
	@Test
	void 롬복테스트() {
		Car car1 = new Car();
		
		car1.setModel("펠리세이드");
		car1.setCompany("현대");
		car1.setColor("회색");
		
		System.out.println(car1.getModel());
		System.out.println(car1.getCompany());
		System.out.println(car1.getColor());
		
		Car car2 = new Car("아반떼", "현대", "검정");
		
		System.out.println(car2.toString());
		
		Car car3 = Car
				.builder()
				.model("쿠펜")
				.company("벤츠")
				.color("흰색")
				.build();
		
		System.out.println(car3);
		
	}
	
}


