package com.example.yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("a")
    @ResponseBody
    public String test(){
        System.out.println("hello world");
        return "hello world";
    }
}
