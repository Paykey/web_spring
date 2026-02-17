package com.example.web_spring.dto;

import com.example.web_spring.Post;

public class PostDto
{
    private String title;
    private String content;

    public PostDto()
    {
    }

    public PostDto(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    // getter
    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }

    // setter
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    // DTO 내용을 Entity로
    public Post toEntity()
    {
        return new Post(this.title, this.content);
    }
}
