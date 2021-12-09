package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)    //테스트 진행할때 JUnit에 내장된 실행자 외에 다른거 실행할때쓴다. 여기선 SpringExtension실행시킨다.
@WebMvcTest(controllers = HelloController.class)//web에 집중할수있는 어노테이션
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 been을 주입받음
    private MockMvc mvc;    //웹api테스트할때 사용됨 get,post등 테스트가능

    @Test
    public void hello가리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))  ///hello주소로 get요청함
                .andExpect(status().isOk()) // http header의 status를 검증. 200 404 500등의 상태를 검증( 여기서는 200검증)
                .andExpect(content().string(hello)); // 응답 본문 내용을 검증. 여기선 hello를 리턴하는지 검증함
    }

    @Test
    public void HelloDTO가리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))        //JsonPath JSON응답값을 필드별로 검증 $를기준으로 필드명 명시
                .andExpect(jsonPath("$.amount",is(amount)));




    }

}
