package com.example.demo.service;

import com.example.demo.dao.Schedule;
import com.example.demo.service.base.BaseCrudService;
import com.example.demo.util.ResultDto;

import java.util.Map;

public interface ScheduleService extends BaseCrudService<Schedule,Long>{
    ResultDto listgetDay(Map<String, String> data);
    ResultDto listgetDayCount(Map<String, String> data);
}
