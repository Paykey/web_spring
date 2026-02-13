package com.example.web_spring;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HelloController
{
    private final PostRepository postRepository; // 창고 관리자 불러오기

    //  생성자
    public HelloController(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    // 게시물 작성 (DB에 저장)
    @PostMapping("/posts")
    public String writePost(@RequestBody Post post)
    {
        postRepository.save(post);
        return "DB에 저장합니다. 제목: " + post.getTitle();
    }

    //  게시물 목록 조회 (DB에서 가져옴)
    @GetMapping("/list")
    public List<Post> getPostList()
    {
        return postRepository.findAll();
    }
}