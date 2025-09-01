package com.kh.tymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class ThymeleafLayoutController {

    @GetMapping("/fragmentTest")
    public String fragmentTest(){
        return "fragment/main";
    }

    @GetMapping("/layout1")
    public String layout1(){
        return "member/memberList";
    }

    @GetMapping("/layout2")
    public String layout2(){
        return "member/myPage";
    }
}
