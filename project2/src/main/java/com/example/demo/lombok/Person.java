package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // 출력시 주소가 나옴(재정의)
@NoArgsConstructor // 생성자(디폴트)
@AllArgsConstructor // 생성자(AllArgs)
@Builder // 생성자
public class Person {

	String name;
	int age;
}
