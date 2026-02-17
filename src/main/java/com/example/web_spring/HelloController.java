package com.example.web_spring;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HelloController
{
    private final PostService postService;

    //  생성자
    public HelloController(PostService postService)
    {
        this.postService = postService;
    }

    // 게시물 작성 (DB에 저장)
    @PostMapping("/posts")
    public String writePost(@RequestBody Post post)
    {
        Post savedPost = postService.writePost(post);
        return "DB에 저장합니다. 제목: " + savedPost.getTitle();
    }

    //  게시물 목록 조회 (DB에서 가져옴)
    @GetMapping("/list")
    public List<Post> getPostList()
    {
        return postService.getPostList();
    }

    // 게시물 업데이트
    @PutMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody Post newPost)
    {
        Post updatedPost = postService.updatePost(id, newPost);

        return "게시물을 수정하였습니다. 바뀐 제목: " + updatedPost.getTitle();
    }

    //  게시물 삭제
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id)
    {
        postService.deletePost(id);
        return "ID: " + id + " 의 게시물이 삭제되었습니다.";
    }



}