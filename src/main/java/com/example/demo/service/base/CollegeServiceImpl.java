package com.example.demo.service.base;

import com.example.demo.dao.base.College;
import com.example.demo.dao.base.CollegeDao;
import com.example.demo.util.ResultDto;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CollegeServiceImpl implements CollegeService{
    @Autowired
    CollegeDao collegeDao;
    @Override
    public ResultDto save(College college) {
        return null;
    }

    @Override
    public ResultDto update(College college) {
        return null;
    }

    @Override
    public ResultDto del(College college) {
        return null;
    }

    @Override
    public ResultDto info(Long id) {
        return null;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        if (StringUtils.isNotBlank(data.get("id"))) {
            resultDto.setData(collegeDao.findById(NumberUtils.toLong(data.get("id"))));
        }else {
            resultDto.setData(collegeDao.findAll());
        }
        return resultDto;
    }
}
