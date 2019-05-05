package com.example.demo.service;

import com.example.demo.dao.Teacher;
import com.example.demo.dao.TeacherDao;
import com.example.demo.util.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeacherDao teacherDao;
    @Override
    public ResultDto save(Teacher teacher) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(teacherDao.save(teacher));
        return resultDto;
    }

    @Override
    public ResultDto update(Teacher teacher) {
        return null;
    }

    @Override
    public ResultDto del(Teacher teacher) {
        return null;
    }

    @Override
    public ResultDto info(Long id) {
        return null;
    }

    @Override
    public ResultDto infoNo(String id) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(teacherDao.findByTeacherno(id));
        return resultDto;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(teacherDao.findByTeacherno(data.get("username")));
        return resultDto;
    }

    @Override
    public ResultDto mainlist(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        char [] array=new char[]{'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        List<Map<String,String>> mapList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (teacherDao.findMainList(String.valueOf(array[i]), Long.valueOf(data.get("deptid"))).size() != 0) {
                Map map = new HashMap();
                map.put("indexKey", array[i]);
                map.put("data", teacherDao.findMainList(String.valueOf(array[i]), Long.valueOf(data.get("deptid"))));
                mapList.add(map);
            }
        }
        resultDto.setData(mapList);
        return resultDto;
    }
}
