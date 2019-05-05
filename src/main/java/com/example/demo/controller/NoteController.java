package com.example.demo.controller;

import com.example.demo.dao.Note;
import com.example.demo.service.NoteServiceImpl;
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
@Api(tags = "通知")
@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    NoteServiceImpl service;
    @PostMapping("/save")
    public ResponseEntity<ResultDto> save(@RequestBody RequestDto<Note> dto){
        return new ResponseEntity<>(service.save(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ResultDto> update(@RequestBody RequestDto<Note> dto){
        return new ResponseEntity<>(service.update(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/list")
    public ResponseEntity<ResultDto> list(@RequestBody RequestDto<Map<String,String>> dto){
        return new ResponseEntity<>(service.list(dto.getData()), HttpStatus.OK);
    }
    @PostMapping("/info")
    public ResponseEntity<ResultDto> info(@RequestBody RequestDto<Note> dto){
        return new ResponseEntity<>(service.info(dto.getData().getId()), HttpStatus.OK);
    }
    @PostMapping("/count")
    public ResponseEntity<ResultDto> count(){
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }
    @PostMapping("/clickupdate")
    public ResponseEntity<ResultDto> clickupdate(@RequestBody RequestDto<Note> dto){
        return new ResponseEntity<>(service.updateNew(dto.getData()), HttpStatus.OK);
    }
}
