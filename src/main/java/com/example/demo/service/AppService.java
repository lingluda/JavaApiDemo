package com.example.demo.service;

import com.example.demo.dao.App;
import com.example.demo.service.base.BaseCrudService;
import com.example.demo.util.ResultDto;

import java.util.List;
import java.util.Map;

public interface AppService extends BaseCrudService<App,Long> {
    ResultDto listAll(Map<String, String> data);
    ResultDto updateList(List<App> list);
}
