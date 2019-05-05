package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher,Long>,JpaSpecificationExecutor{
    Teacher findByTeacherno(String no);
    @Query(value = "select * from teacher where substr(cjh,0,1)=?1 AND deptid = ?2",nativeQuery = true)
    List<Teacher> findMainList(String key,Long id);
}
