package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }


    @GetMapping("/")    //앞의경로가 생략된다
    public String index(Model model){       // model = 객체를 저장할수있다
        model.addAttribute("posts",postsService.findAllDesc());
        return "index"; //.mustache가 생략된다
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
