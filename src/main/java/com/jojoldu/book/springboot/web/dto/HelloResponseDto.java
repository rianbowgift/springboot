package com.jojoldu.book.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //생성된 모든필드에 get메소드추가
@RequiredArgsConstructor //final필드가 포함된 생성자.(final없는건 생성안됨)
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
