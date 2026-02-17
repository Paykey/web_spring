package com.example.web_spring;

import com.example.web_spring.dto.PostDto;
import com.example.web_spring.dto.PostResponseDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<PostResponseDto> getPostList()
    {
        return postRepository.findAll().stream()    // DB에서 꺼내서 스트림으로 만듬
                .map(PostResponseDto::new)          // 하나씩 DTO로 변환 (리스트의 모든 Post를 하나씩 PostResponseDto로)
                .collect(Collectors.toList());      // DTO들을 리스트로 묶음
    }

    // 게시물 업데이트
    public Post updatePost(Long id, PostDto postDto)
    {
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 ID의 글이 존재하지 않습니다."));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        return postRepository.save(post);
    }

    // 게시물 삭제
    public void deletePost(Long id)
    {
        postRepository.deleteById(id);
    }
}
