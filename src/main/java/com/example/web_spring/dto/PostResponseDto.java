package com.example.web_spring.dto;

import com.example.web_spring.Post;

public class PostResponseDto
{
    private Long id;
    private String title;
    private String content;

    // DTO 변환 생성자
    public PostResponseDto(Post post)
    {
        this.id = post.getId();
        this.title = post.getTitle();;
        this.content = post.getContent();
    }

    // getter
    public Long getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public String getContent()
    {
        return content;
    }
}
