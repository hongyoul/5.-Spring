package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;


// Board 데이터를 '처리'할 리파지토리 생성
public interface BoardRepository extends JpaRepository<Board, Integer> {

	// 부모한테 물려받은 crud 메소드가 있음
	// save findAll findBy ...
}
