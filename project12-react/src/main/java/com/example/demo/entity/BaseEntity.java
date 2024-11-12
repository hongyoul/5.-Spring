package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

// 테이블과 직접 매필되는 데이블이 아님을 명시, 상속이 목적!
@MappedSuperclass

// 이벤트 발생을 감지하는 리스너 설정
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
public abstract class BaseEntity {

	// insert 발생시 현재 시간이 자동으로 저장됨(한번)
    @CreatedDate 
    @Column(updatable = false)
    LocalDateTime regDate; // 날짜 + 시간 + 타임존

    
    //update 발생시 현재 시간이 자동으로 저장됨(여러번)
    @LastModifiedDate 
    LocalDateTime modDate;

}
