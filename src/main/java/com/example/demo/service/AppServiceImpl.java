package com.example.demo.service;

import com.example.demo.dao.App;
import com.example.demo.dao.AppDao;
import com.example.demo.util.ResultDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    AppDao appDao;

    @Override
    public ResultDto save(App app) {
        ResultDto resultDto = new ResultDto();
        resultDto.setData(appDao.save(app));
        return resultDto;
    }

    @Override
    public ResultDto update(App app) {
        ResultDto resultDto = new ResultDto();
        return resultDto;
    }

    @Override
    public ResultDto updateList(List<App> list) {
        ResultDto resultDto = new ResultDto();
        appDao.save(list);
        List<Long> list1 = new ArrayList<>();
        for (App x:list
             ) {
            list1.add(x.getId());
        }
        List<App> notlist = appDao.findByIdNotIn(list1);
        for (App n:notlist
             ) {
            n.setIsMine(false);
        }
        appDao.save(notlist);
        return resultDto;
    }

    @Override
    public ResultDto del(App app) {
        return null;
    }

    @Override
    public ResultDto info(Long id) {
        return null;
    }

    @Override
    public ResultDto list(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();
       /* Specification<App> specification = new Specification<App>() {

            @Override
            public Predicate toPredicate(Root<App> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(StringUtils.isNotBlank(data.get("ismine"))){
                    Predicate p1 = cb.equal(root.get("ismine"),data.get("ismine"));

                }
                    return null;
            }
        };*/
        if (StringUtils.isNotBlank(data.get("isMine")) && data.get("isMine").equals("true")) {
            resultDto.setData(appDao.findByIsMineIsTrue());
        } else {

            List<Map<String, Object>> mapList = new ArrayList<>();
            List<App> appList = appDao.findAll(new Sort(Sort.Direction.ASC, "id"));
            List<App> appList1 = appList.subList(0, 6);
            List<App> appList2 = appList.subList(6, 8);
            List<App> appList3 = appList.subList(8, 16);
            List<App> appList4 = appList.subList(16, 24);

            Map m = new HashMap();
            m.put("title", "综合管理");
            m.put("list", appList1);
            mapList.add(m);
            Map m1 = new HashMap();
            m1.put("title", "任务管理");
            m1.put("list", appList2);
            mapList.add(m1);
            Map m2 = new HashMap();
            m2.put("title", "学生管理");
            m2.put("list", appList3);
            mapList.add(m2);
            Map m3 = new HashMap();
            m3.put("title", "申请审核");
            m3.put("list", appList4);
            mapList.add(m3);
            resultDto.setData(mapList);
        }
        return resultDto;
    }

    @Override
    public ResultDto listAll(Map<String, String> data) {
        ResultDto resultDto = new ResultDto();

        List<App> list = appDao.findAll();
        return resultDto;
    }
}
