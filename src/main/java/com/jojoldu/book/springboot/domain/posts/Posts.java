package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Getter //기본 게터생성자 추가
//@Setter //코드의 구분상 Entity클래스에서는 절대로 세터를 생성해선 안된다. 대신 필요할경우 의도를 알수있는 메소드를 따로 추가하여 변경하여야한다.
@NoArgsConstructor  //기본생성자 자동추가. posts(){}와같음
@Entity //테이블과 링크될 클래스를 알림
public class Posts extends BaseTimeEntity {

    @Id // pk필드(고유)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk생성규칙.
    private Long id;

    @Column(length = 500, nullable = false) //테이블 칼럼 , 안해줘도되는데 사이즈조정 같은거 하려면 선언한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 생성자 상단에선언시 생성자에 포함된 필드만 빌더에포함 (?)
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
