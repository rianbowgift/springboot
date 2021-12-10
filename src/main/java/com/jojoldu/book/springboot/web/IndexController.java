package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")    //앞의경로가 생략된다
    public String index(){
        return "index"; //.mustache가 생략된다
    }
}
