package com.example.demo.controller;

import com.example.demo.dao.Teacher;
import com.example.demo.service.TeacherServiceImpl;
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

@Api(tags = "老师")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;
    @PostMapping("/info")
    public ResponseEntity<ResultDto> info(@RequestBody RequestDto<Teacher> dto){
        return new ResponseEntity<>(teacherService.infoNo(dto.getData().getTeacherno()), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ResultDto> save(@RequestBody RequestDto<Teacher> dto){
        return new ResponseEntity<>(teacherService.save(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/mainlist")
    public ResponseEntity<ResultDto> mainlist(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(teacherService.mainlist(dto.getData()), HttpStatus.OK);
    }
}
