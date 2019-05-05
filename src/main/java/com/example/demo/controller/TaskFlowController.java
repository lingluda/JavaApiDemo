package com.example.demo.controller;

import com.example.demo.dao.TaskFlow;
import com.example.demo.service.TaskFlowServiceImpl;
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
@Api(tags = "代办")
@RestController
@RequestMapping("/taskflow")
public class TaskFlowController {
    @Autowired
    TaskFlowServiceImpl taskFlowService;
    @PostMapping("/list")
    public ResponseEntity<ResultDto> list(@RequestBody RequestDto<Map<String,String>>dto){
        return new ResponseEntity<>(taskFlowService.list(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/info")
    public ResponseEntity<ResultDto> info(@RequestBody RequestDto<TaskFlow>dto){
        return new ResponseEntity<>(taskFlowService.info(dto.getData().getId()), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ResultDto> update(@RequestBody RequestDto<TaskFlow>dto){
        return new ResponseEntity<>(taskFlowService.update(dto.getData()), HttpStatus.OK);
    }
}
