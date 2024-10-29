package com.example.demo.di;

public interface Teacher {

	// interface은 Abstract 생략 가능(자동 생략됨)
	
	void teach();
}


// Teacher Type의 빈을 컨테이너에 등록해야됨
// Teacher를 상속받은 구현체(MathTeacher, ScienceTeacher) 중에서 하나만 선택해야 함
// @Component은 하나만 사용이 가능하기 때문에 두개에 구현체에 전부 사용할 수 없다.