package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface productDao extends JpaRepository<Product,Long>,JpaSpecificationExecutor{
    List<Product> findAllByName(String name);
    List<Product> findAll();
    Product findById(Long id);
}
