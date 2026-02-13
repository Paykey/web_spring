package com.example.web_spring;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<대상객체, ID타입>
public interface PostRepository extends JpaRepository<Post, Long>
{
    // 스프링이 알아서 save(저장), findAll(조회), delete(삭제) 기능을 생성
}