package com.example.demo.di;

//@Component
public class MathTeacher implements Teacher{
	
	// implements의 자식은 오버라이딩(Override) 하기

	@Override
	// 재정의가 이루어지는 부분
	public void teach() {
		System.out.println("수학 선생님이 수업을 가르칩니다");
		
	}


}
