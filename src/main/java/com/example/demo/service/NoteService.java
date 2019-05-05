package com.example.demo.service;

import com.example.demo.dao.Note;
import com.example.demo.service.base.BaseCrudService;
import com.example.demo.util.ResultDto;

import java.util.Map;

public interface NoteService extends BaseCrudService<Note,Long>{
    ResultDto count();
    ResultDto updateNew(Note note);
}
