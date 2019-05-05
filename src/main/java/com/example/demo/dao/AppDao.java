package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.List;

public interface AppDao extends JpaRepository<App,Long>,JpaSpecificationExecutor{
    List<App> findByIsMineIsFalse();
    List<App> findByIsMineIsTrue();
    List<App> findByIdNotIn(List<Long> list);
}
