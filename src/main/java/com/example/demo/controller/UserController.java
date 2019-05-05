
package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "用户")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserDao userDao;
    @GetMapping("/save")
    public User save(String name,String password){
        User user = null;
        if(name!=null&&password!=null){
         //user = userDao.save(new User(null,name,password));
        }
        return  user;
    }
    @GetMapping("/login")
    public User login(String name,String password){
        User u = userDao.findByUsernameAndPassword(name,password);
        return u;
    }
}

