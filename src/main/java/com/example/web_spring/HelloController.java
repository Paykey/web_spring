package com.example.web_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private List<Post> posts = new ArrayList<>();

    @GetMapping("/write")
    public String writePost(@RequestParam("title") String title, @RequestParam("content") String content)
    {
        posts.add(new Post(title, content));
        return "저장 완료! 현재 글 개수: " + posts.size();
    }

    @GetMapping("/list")
    public List<Post> getPostList()
    {
        return posts;
    }
}