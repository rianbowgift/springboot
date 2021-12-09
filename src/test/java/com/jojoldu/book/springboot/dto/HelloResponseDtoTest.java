package com.jojoldu.book.springboot.dto;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void 롬북기능테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  //검증하고싶은인자를받음
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
