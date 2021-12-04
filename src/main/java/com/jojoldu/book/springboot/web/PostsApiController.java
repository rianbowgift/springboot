package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor //final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌. 생성자를안쓰고 이거쓰는이유-> 클래스 의존성 바뀔때마다 수정할필요없어짐
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);

    }

}
