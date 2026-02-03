package com.example.web_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "웹 홈";
    }

    @GetMapping("/test")
    public String myTest() {
        return "여기는 테스트 페이지입니다";
    }

    @GetMapping("/intro")
    public String intro(){
        return "인트로 페이지";
    }

    @GetMapping("/hello")
    public String helloUser(@RequestParam(value = "name", defaultValue = "사용자") String userName) {
        return userName + "님, 환영합니다!";
    }
}