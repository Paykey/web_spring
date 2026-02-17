package com.example.web_spring;

import com.example.web_spring.dto.PostDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService
{
    private final PostRepository postRepository;

    // Repository 가져옴
    public PostService(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    // 게시물 작성
    public Post writePost(PostDto postDto)
    {
        // DTO에서 내용물을 Entity로
        Post post = postDto.toEntity();

        return postRepository.save(post);
    }

    // 게시물 모두 불러오기
    public List<Post> getPostList()
    {
        return postRepository.findAll();
    }

    // 게시물 업데이트
    public Post updatePost(Long id, Post newPost)
    {
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 ID의 글이 존재하지 않습니다."));

        post.setTitle(newPost.getTitle());
        post.setContent(newPost.getContent());

        return postRepository.save(post);
    }

    // 게시물 삭제
    public void deletePost(Long id)
    {
        postRepository.deleteById(id);
    }
}
