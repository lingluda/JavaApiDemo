
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor {
    User findByUsernameAndPassword(String name,String password);
    User findByUsername(String name);
}

