package com.jojoldu.book.springboot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //JPA 엔티티 클래스들이 이클레스를 상속할경우 필드도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)  //auditing기능 포함시킴
public class BaseTimeEntity {

    @CreatedDate    // 엔티티가 생성되서 저장되는시간을 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate       // 조회한 엔티티값을 변경할때 시간이 자동저장
    private LocalDateTime modifiedDate;
}
