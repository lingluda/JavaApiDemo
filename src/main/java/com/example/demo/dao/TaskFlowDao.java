package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskFlowDao extends JpaRepository<TaskFlow,Long>,JpaSpecificationExecutor{
}
