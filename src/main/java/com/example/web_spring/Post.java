package com.example.web_spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 스프링 실행시 DB에 Post 테이블 생성
public class Post
{
    @Id // 고유 ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // 기본 생성자
    public Post()
    {
    }

    // 생성자
    public Post(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    //  Getter
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
    //  Setter
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

}
