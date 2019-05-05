package com.example.demo.service.base;

import com.example.demo.util.ResultDto;

import java.util.Map;

public interface BaseCrudService<Model,PK>{
    ResultDto save(Model model);
    ResultDto update(Model model);
    ResultDto del(Model model);
    ResultDto info(PK id);
    ResultDto list(Map<String, String> data);
}
