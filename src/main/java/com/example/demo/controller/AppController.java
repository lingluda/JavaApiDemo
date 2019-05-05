package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.App;
import com.example.demo.service.AppServiceImpl;
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

import java.util.List;
import java.util.Map;
@Api(tags = "应用")
@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    AppServiceImpl appService;
    @PostMapping("/save")
    public ResponseEntity<ResultDto> save(@RequestBody RequestDto<App> dto){
        return new ResponseEntity<>(appService.save(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/list")
    public ResponseEntity<ResultDto> list(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(appService.list(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ResultDto> update(@RequestBody RequestDto<List<App>> dto){
        //JSONObject jsonObject = dto.getData();
        //JSONArray jsonArray = jsonObject.getJSONArray("app");
        System.out.println(dto.getData());
        return new ResponseEntity<>(appService.updateList(dto.getData()), HttpStatus.OK);
    }
}
