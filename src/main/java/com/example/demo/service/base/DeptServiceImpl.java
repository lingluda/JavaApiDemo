package com.example.demo.service.base;

import com.example.demo.dao.base.Dept;
import com.example.demo.dao.base.DeptDao;
import com.example.demo.util.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    DeptDao deptDao;
    @Override
    public ResultDto save(Dept dept) {
        return null;
    }

    @Override
    public ResultDto update(Dept dept) {
        return null;
    }

    @Override
    public ResultDto del(Dept dept) {
        return null;
    }

    @Override
    public ResultDto info(Long id) {
        return null;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(deptDao.findAll());
        return resultDto;
    }
}
