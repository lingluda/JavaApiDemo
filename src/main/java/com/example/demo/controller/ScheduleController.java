package com.example.demo.controller;

import com.example.demo.dao.Schedule;
import com.example.demo.service.ScheduleServiceImpl;
import com.example.demo.util.RequestDto;
import com.example.demo.util.ResultDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@Api(tags = "日程")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleServiceImpl scheduleService;
    @PostMapping("/save")
    public ResponseEntity<ResultDto> save(@RequestBody RequestDto<Schedule> dto){
        return new ResponseEntity<>(scheduleService.save(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ResultDto> update(@RequestBody RequestDto<Schedule> dto){
        return new ResponseEntity<>(scheduleService.update(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/list")
    public ResponseEntity<ResultDto> list(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(scheduleService.list(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/daylist")
    public ResponseEntity<ResultDto> daylist(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(scheduleService.listgetDay(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/daycount")
    public ResponseEntity<ResultDto> daycount(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(scheduleService.listgetDayCount(dto.getData()), HttpStatus.OK);
    }
}
