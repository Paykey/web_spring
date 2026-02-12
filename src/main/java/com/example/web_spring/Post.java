package com.example.web_spring;

public class Post {
    private String title;
    private String content;

    // 빈 깡통
    public Post()
    {

    }

    // 생성자
    public Post(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}
