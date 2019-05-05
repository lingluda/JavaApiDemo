package com.example.demo.service.base;

import com.example.demo.dao.User;
import com.example.demo.dao.UserDao;
import com.example.demo.util.ResultDto;
import com.example.demo.util.jwt.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public ResultDto save(User user) {
        return null;
    }

    @Override
    public ResultDto update(User user) {
        return null;
    }

    @Override
    public ResultDto del(User user) {
        return null;
    }

    @Override
    public ResultDto login(User user) {
        ResultDto resultDto = new ResultDto();
        User u = userDao.findByUsername(user.getUsername());
        if (u==null){
            resultDto.setCode("warning");
            resultDto.setMsg("没有此用户！请与系统管理员联系!");
        }
        else if (StringUtils.isNotBlank(user.getPassword())&&u.getPassword().equals(user.getPassword())){
            resultDto.setData(JWTUtil.sign(u.getUsername(),u.getUsername()));
        }
        else {
            resultDto.setCode("error");
            resultDto.setMsg("密码错误！请重新输入！");
        }
        return resultDto;
    }

    @Override
    public ResultDto info(Long id) {
        return null;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        return null;
    }
}
