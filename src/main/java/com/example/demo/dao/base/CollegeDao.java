package com.example.demo.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeDao extends JpaRepository<College,Long>{
    List<College> findById(Long id);
}
