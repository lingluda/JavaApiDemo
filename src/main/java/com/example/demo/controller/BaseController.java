package com.example.demo.controller;

import com.example.demo.dao.Base;
import com.example.demo.service.BaseServiceImpl;
import com.example.demo.util.RequestDto;
import com.example.demo.util.ResultDto;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@Api(tags = "智障")
@RestController
@RequestMapping("/base")
public class BaseController {
    @Resource
    BaseServiceImpl baseService;
    @PostMapping("/save")
    public ResponseEntity<ResultDto> save(@RequestBody RequestDto<Base> dto){
        return new ResponseEntity<>(baseService.save(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ResultDto> update(@RequestBody RequestDto<Base> dto){
        return new ResponseEntity<>(baseService.update(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/del")
    public ResponseEntity<ResultDto> del(@RequestBody RequestDto<Base> dto){
        return new ResponseEntity<>(baseService.del(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/list")
    //@RequiresAuthentication
    public ResponseEntity<ResultDto> list(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(baseService.list(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/list2")
    public ResponseEntity<ResultDto> list2(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(baseService.list2(dto.getData()), HttpStatus.OK);
    }
}
