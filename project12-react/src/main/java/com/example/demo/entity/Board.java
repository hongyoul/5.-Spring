package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Entity: DB에 데이터를 담아서 전달한는 역할
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseEntity {

	// PK + Auto increment 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int no;

    // 컬럼의 정보 : 길이 + Not Null
    @Column(length = 100, nullable = false)
    String title;

    @Column(length = 1500, nullable = false)
    String content;

    // 외래키 설정 : 자료형 바꾸기
    @ManyToOne // 관계차수 1:N 설정
    Member writer;
    
    // 관계차수
    // 1:1 => 회원은 게시물 하나만 작성할 수 있다
    // 1:N => 회원은 게시물 여러개 작성할 수 있다
}
