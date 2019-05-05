package com.example.demo.service;

import com.example.demo.dao.TaskFlow;
import com.example.demo.dao.TaskFlowDao;
import com.example.demo.util.ResultDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class TaskFlowServiceImpl implements TaskFlowService{
    @Autowired
    TaskFlowDao taskFlowDao;
    @Override
    public ResultDto save(TaskFlow taskFlow) {
        return null;
    }

    @Override
    public ResultDto update(TaskFlow taskFlow) {
        ResultDto resultDto = new ResultDto();
        TaskFlow taskFlow1 = taskFlowDao.findOne(taskFlow.getId());
        taskFlow1.setApprovestatus(taskFlow.getApprovestatus());
        taskFlow1.setComments(taskFlow.getComments());
        taskFlow1.setModifiedtime(new Date());
        taskFlowDao.save(taskFlow1);
        return resultDto;
    }

    @Override
    public ResultDto del(TaskFlow taskFlow) {
        return null;
    }

    @Override
    public ResultDto info(Long id) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(taskFlowDao.findOne(id));
        return resultDto;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(data.get("approvestatus"))) {
                    Predicate p1 = cb.equal(root.get("approvestatus"), data.get("approvestatus"));
                    predicates.add(p1);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        Pageable pageable = new PageRequest(1,2);
        resultDto.setData(taskFlowDao.findAll(specification));
        return resultDto;
    }
}
