package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")    //앞의경로가 생략된다
    public String index(){
        return "index"; //.mustache가 생략된다
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
