package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleDao extends JpaRepository<Schedule,Long>,JpaSpecificationExecutor{
    @Query(value = "SELECT * FROM SCHEDULE t WHERE to_char(t.STARTTIME,'YYYYMM')=to_char(SYSDATE,'YYYYMM')",nativeQuery = true)
    List<Schedule> getday();
    @Query(value = "SELECT * FROM SCHEDULE t WHERE to_char(t.STARTTIME,'YYYY-MM')=?1",nativeQuery = true)
    List<Schedule> getMonth(String month);
    @Query(value = "SELECT * FROM SCHEDULE WHERE endtime BETWEEN SYSDATE and" +
            " to_date((select to_char(sysdate+1,'yyyy-mm-dd') as data from dual),'yyyy-mm-dd hh24:mi:ss')" +
            " and userid = ?1 order by starttime desc",nativeQuery = true)
    List<Schedule> scheduleCount(Long id);
}
