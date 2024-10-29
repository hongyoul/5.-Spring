package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//스프링 MVC 없이 순수한 자바클래스로 회원 관리 기능을 구현한 가상 리파지토리
//테이블 대신 Map을 사용하여 회원 정보를 저장하고 관리

public class MemberRepository {

	// 회원 정보를 저장할 Map (키:회원번호, 값:회원객체)
    static Map<Integer, Member> store = new HashMap<>();
	
    // 회원 번호룰 자동으로 생성하기 위한 시퀀스
    static int sequence = 0;
    
 // 새로운 회원을 저장소에 추가
    public Member save(Member member) {
    	
    	// 회원이 추가될 때마다 시퀀스를 1씩 증가하여 사용함
        member.setNo(++sequence);
        store.put(member.getNo(), member);
        return member;
    }
    
    // 회원번호(key값)로 특정 회원 정보를 조회(= 단건 조회)
//    public Member findById(int id) {
//        return store.get(id);
//    }
    public Member findById(int no) {
    	return store.get(no);
    }
    
 // 저장소에 있는 모든 회원을 조회(= 전체 조회)
    // Map의 값을 List로 변환하여 반환 
    public List<Member> findAll() {	
    	
    	// 저장소에 있는 모든 데이터 꺼내기
//    	Collection<Member> result = store.values();
    	
    	// Map의 값을 Lost로 변환하여 반환
//    	List<Member> list = new ArrayList<>(result);
//    	return list;
    	
    	// List 타입 줄인 값(변환과정은 위에 식임)
        return new ArrayList<>(store.values());
    }
    
    // 저장소에 있는 모든 회원 정보를 삭제
    public void clearStore() {
        store.clear(); // 전체
        
        store.remove(1); // 단건
        
    }
    
}
