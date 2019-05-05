package com.example.demo.service.base;

import com.example.demo.dao.User;
import com.example.demo.util.ResultDto;

import java.util.Map;

public interface UserService extends BaseCrudService<User,Long>{
    ResultDto login(User user);
}
