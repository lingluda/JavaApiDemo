package com.example.demo.dao;

import com.example.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface commentDao extends JpaRepository<Comment,Long>,JpaSpecificationExecutor {
    List<Comment> findAllByProductId(Long id);
}
