package com.example.web_spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/posts")
    public String writePost(@RequestBody Post post)
    {
        posts.add(post);
        return "저장 완료! 제목: " + post.getTitle();
    }
}