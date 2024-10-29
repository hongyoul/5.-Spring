package com.example.demo.entity;



import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// 엔티티에 변화를 감지하는 리스너 설정
@EntityListeners(AuditingEntityListener.class)


@Entity // jpa에서 관리하는 엔티티 표시
@Table(name = "tbl_board")

// 밑에 @은 롬복(lombok)입니다.
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 롬복 -끝-

public class Board {

	
	@Id // PK + AUTO INCREAMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo; // 게시물 번호

	// 컬럼의 정보 설정(크기, NOTNULL 옵션)
	@Column(length = 30, nullable = false) //null X
	String title;
	
	@Column(length = 200) // null OK
	String content;

	@CreatedDate // INSERT 시 실행
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime createdDate; // (최초)등록일

	@LastModifiedDate // INSERT 및 UPDATE 시 실행
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate; // (최종)수정일

}
