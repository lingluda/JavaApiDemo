package com.example.demo.service;

import com.example.demo.dao.Teacher;
import com.example.demo.service.base.BaseCrudService;
import com.example.demo.util.ResultDto;

import java.util.Map;

public interface TeacherService extends BaseCrudService<Teacher,Long>{
    ResultDto mainlist(Map<String, String> data);
    ResultDto infoNo(String id);
}
