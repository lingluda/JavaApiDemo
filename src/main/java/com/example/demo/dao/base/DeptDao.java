package com.example.demo.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DeptDao extends JpaRepository<Dept,Long>{
    @Query(value = "SELECT * FROM DEPT",nativeQuery = true)
    List<Object[]> findxx();
}
