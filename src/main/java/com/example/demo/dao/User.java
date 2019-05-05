
package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "suser")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
/*    @OneToOne
    @JoinColumn
    private ZsTeacher zsTeacher;*/
    @Column(length = 24)
    private String username;
    @Column(length = 50)
    private String password;
    @Column(length = 150)
    private String token;
    @Column(length = 50)
    private String role;
    @Column(length = 50)
    private String permission;
    private Date createtime;
    private Date modifiedtime;

    public User(){
        super();
    }
    public User(Long id,String username,String role,String password,String permission,Date createtime,Date modifiedtime,String token){
        this.id=id;this.username=username;this.password=password;this.role=role;this.permission=permission;this.createtime=createtime;this.modifiedtime=modifiedtime;this.token=token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

