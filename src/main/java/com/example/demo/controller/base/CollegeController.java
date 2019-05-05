package com.example.demo.controller.base;

import com.example.demo.service.base.CollegeServiceImpl;
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
@Api(tags = "院系")
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeServiceImpl collegeService;
    @PostMapping("/list")
    public ResponseEntity<ResultDto> list(@RequestBody RequestDto<Map<String,String>>dto){
        return new ResponseEntity<>(collegeService.list(dto.getData()), HttpStatus.OK);
    }
}
