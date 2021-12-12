package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;


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
