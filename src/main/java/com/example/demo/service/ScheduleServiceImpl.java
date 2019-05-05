package com.example.demo.service;

import com.example.demo.dao.Schedule;
import com.example.demo.dao.ScheduleDao;
import com.example.demo.util.ResultDto;
import com.example.demo.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleDao scheduleDao;
    @Override
    public ResultDto save(Schedule schedule) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(scheduleDao.save(schedule));
        return resultDto;
    }

    @Override
    public ResultDto update(Schedule schedule) {
        ResultDto resultDto = new ResultDto();
        if (schedule.getId() == null){
            resultDto.setCode("error");
        }
        resultDto.setData(scheduleDao.save(schedule));
        return resultDto;
    }

    @Override
    public ResultDto del(Schedule notes) {
        return null;
    }

    @Override
    public ResultDto info(Long id) {
        ResultDto resultDto = new ResultDto();
        return resultDto;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        Specification<Schedule> productSpecification = new Specification<Schedule>() {
            @Override
            public Predicate toPredicate(Root<Schedule> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date starttime = null;
                Date endtime;

                Predicate p1 = cb.equal(root.get("userid"),data.get("userid"));
                predicates.add(p1);
                if (StringUtils.isNotBlank(data.get("starttime"))){
                    try {
                        starttime = format.parse(data.get("starttime"));
                        //endtime = format.parse(data.get("endtime"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    endtime =starttime;
                    Calendar calendar = Calendar.getInstance() ;
                    calendar.setTime(starttime);
                    calendar.add(Calendar.DATE, 1);
                    endtime = calendar.getTime();
                    calendar = null;

                    Predicate p2 = cb.between(root.<Date>get("starttime"),starttime,endtime);
                    predicates.add(p2);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        String key = "createtime";
        if (StringUtils.isNotBlank(data.get("direction"))){
             key = data.get("direction");
        }
        int page = NumberUtils.toInt(data.get("page"),1)-1;
        int size = NumberUtils.toInt(data.get("size"),10);
        Sort sort = new Sort(Sort.Direction.DESC, key);
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Schedule> schedulePage = scheduleDao.findAll(productSpecification,pageable);
        resultDto.setData(schedulePage);
        return resultDto;
    }

    @Override
    public ResultDto listgetDay(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        String month = data.get("starttime").substring(0,7);
        List<Schedule> scheduleList = scheduleDao.getMonth(month);
        ArrayList<Integer> a=new ArrayList<>();
        for (int i = 0; i < scheduleList.size(); i++) {
            a.add(TimeUtil.getDay(scheduleList.get(i).getStarttime()));
        }
        resultDto.setData(a);
        return resultDto;
    }

    @Override
    public ResultDto listgetDayCount(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(scheduleDao.scheduleCount(Long.valueOf(data.get("userid"))));
        return resultDto;
    }
}
