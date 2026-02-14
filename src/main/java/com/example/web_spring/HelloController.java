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

    // 게시물 업데이트
    @PutMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody Post newPost)
    {
        //  해당 id의 게시물이 없으면 에러 메시지
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("E: 해당 ID의 글이 존재하지 않습니다."));

        //  게시물 업데이트
        post.setTitle(newPost.getTitle());
        post.setContent(newPost.getContent());

        //  교체 후 다시 저장
        postRepository.save(post);

        return "게시물을 수정하였습니다. 바뀐 제목: " + post.getTitle();
    }

    //  게시물 삭제
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id)
    {
        postRepository.deleteById(id);
        return "ID: " + id + " 의 게시물이 삭제되었습니다.";
    }



}