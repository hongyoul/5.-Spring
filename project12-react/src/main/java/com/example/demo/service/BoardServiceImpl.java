package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository repository;

	@Override
	public int register(BoardDTO dto) {
		Board entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getNo();
	}

	@Override
	public List<BoardDTO> getList() {
		List<Board> entityList = repository.findAll();		
		List<BoardDTO> dtoList = entityList.stream()
				.map(entity -> entityToDto(entity))
//				collect():최종 연산자 스트임을 다른 자료구조로 변환
				.collect(Collectors.toList());

//		변환된 리스트 반환
		return dtoList;
	}

	@Override
	public BoardDTO read(int no) {
//		단건 조회 : 조건 필요 (식벽자 , PK)
        Optional<Board> result = repository.findById(no);
        
        if(result.isPresent()) {
        	Board board =  result.get();
        	return entityToDto(board); // 리턴 값이 왜 오류가 날까?
        } else {
        	return null; // 언제나 리턴이 되도록, 함수의 마지막 부분에 추가
        }
	}

	@Override
	public void modify(BoardDTO dto) {
//         해당 게시물 DB에 존재하는지 확인
        Optional<Board> result = repository.findById(dto.getNo());
//        게시물이 존재한다면 일부 데이터 업데이트
        if(result.isPresent()){
            Board entity = result.get();
//          이 사이트는 게시물의 제목과 내용만 수정 가능
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            repository.save(entity);
        }
//        전달 받은 게시물 데이터를 그대로 업데이트하면 안됨
//        1. 변경되면 안되는 데이터가 변경될 수 있음
//        2. 코드가 실행되는 사이에 해당 게시물이 사라질 수 있음
        
	}

	@Override
	public void remove(int no) {
//		단건 삭제 : 조건 필요(식별자, PK)
		repository.deleteById(no);
	}

}
