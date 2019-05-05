package com.example.demo.service;


import com.example.demo.dao.Note;
import com.example.demo.dao.NoteDao;
import com.example.demo.util.ResultDto;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;

    @Override
    public ResultDto save(Note notes) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(noteDao.save(notes));
        return resultDto;
    }

    @Override
    public ResultDto update(Note notes) {
        ResultDto resultDto = new ResultDto();
        /*Note n = noteDao.findOne(notes.getId());
        n.setIsnew((byte) 0);
        noteDao.save(n);*/
        notes.setModifiedtime(new Date());
        resultDto.setData(noteDao.save(notes));
        return resultDto;
    }

    @Override
    public ResultDto del(Note notes) {
        ResultDto resultDto = new ResultDto();
        return resultDto;
    }

    @Override
    public ResultDto info(Long id) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(noteDao.findOne(id));
        return resultDto;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        int page = NumberUtils.toInt(data.get("page"),1)-1;
        int size = NumberUtils.toInt(data.get("size"),10);
        PageRequest pageable = new PageRequest(page,size,sort);
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (StringUtils.isNotBlank(data.get("content"))){
                    Predicate p1 = cb.like(root.get("content"),"%"+data.get("content")+"%");
                    predicateList.add(p1);
                }
                return cb.and(predicateList.toArray(new Predicate[0]));
            }
        };
        Page<Note> list = noteDao.findAll(specification,pageable);
        resultDto.setData(list);
        return resultDto;
    }

    @Override
    public ResultDto count() {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(noteDao.countNoteByIsnewEquals((byte)1));
        return resultDto;
    }

    @Override
    public ResultDto updateNew(Note note) {
        ResultDto resultDto = new ResultDto();
        Note n = noteDao.findOne(note.getId());
        n.setIsnew((byte) 0);
        noteDao.save(n);
        return resultDto;
    }
}
