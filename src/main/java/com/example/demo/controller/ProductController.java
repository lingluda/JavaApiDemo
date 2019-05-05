
package com.example.demo.controller;

import com.example.demo.dao.productDao;
import com.example.demo.dao.Product;
import com.example.demo.dao.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "商品")
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
    public Page<Product> sort(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0,4,sort);
        Specification<Product> productSpecification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                Predicate p1 = cb.equal(root.get("price"),3);
                predicates.add(p1);
                Predicate p2 = cb.like(root.get("name"),"%"+"处"+"%");
                predicates.add(p2);
                Join<Product,User> userJoin = root.join("user",JoinType.LEFT);
                Predicate p3 = cb.equal(userJoin.get("id"),1);
                predicates.add(p3);
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        Page<Product> p =productDao.findAll(productSpecification,pageable);
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

