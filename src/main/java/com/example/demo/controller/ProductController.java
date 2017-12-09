package com.example.demo.controller;

import com.example.demo.dao.productDao;
import com.example.demo.entity.Product;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    productDao productDao;
    @GetMapping("/save")
    public Product save(String name,Long price,Long rating,String desc,Long fatherid){
           Product p = productDao.save(new Product(null,name,price,rating,desc,fatherid));
           return p;
    }
    @GetMapping("/edit/{id}")
    public Product edit(@PathVariable("id") Long id,String name,Long price,Long rating,String desc,Long fatherid){
        Product p = productDao.save(new Product(id,name,price,rating,desc,fatherid));
        return p;
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        productDao.delete(id);
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id){
        Product p = productDao.findById(id);
        return p;
    }
    @GetMapping("/page")
    public Page<Product> page(){
        Page<Product> p =  productDao.findAll(new PageRequest(1,6));
        return p;
    }
    @GetMapping("/sort")
    public List<Product> sort(){
        List<Product> p =productDao.findAll(new
                Sort(Sort.Direction.ASC,"id"));
        return p;
    }
    @GetMapping("/findByName")
    public List<Product> findByName(String name){
        if(name==null)
            return productDao.findAll(new
                    Sort(Sort.Direction.ASC,"id"));
        List<Product> p = productDao.findAllByName(name);
        return p;
    }
}
