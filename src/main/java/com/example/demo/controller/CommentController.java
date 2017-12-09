package com.example.demo.controller;

import com.example.demo.dao.commentDao;
import com.example.demo.entity.Comment;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    commentDao commentDao;
    @GetMapping("/save")
    public Comment save(Long productId,String timetamp,String user, Long rating, String content){
        Comment comment = commentDao.save(new Comment(null,productId,timetamp,user,rating,content));
        return comment;
    }
    @GetMapping("/sort")
    public List<Comment> findById(){
        List<Comment> comments = commentDao.findAll(new Sort(Sort.Direction.ASC,"id"));
        return comments;
    }
}
