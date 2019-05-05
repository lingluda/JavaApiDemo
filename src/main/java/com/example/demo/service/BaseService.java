package com.example.demo.service;

import com.example.demo.dao.Base;
import com.example.demo.service.base.BaseCrudService;
import com.example.demo.util.ResultDto;

import java.util.Map;

public interface BaseService extends BaseCrudService<Base,Long>{
    ResultDto list2(Map<String, String> data);
}
