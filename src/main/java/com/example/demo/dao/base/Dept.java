package com.example.demo.dao.base;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dept")
public class Dept implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private Long fid;
    @Column(length = 50)
    private String name;
    public Dept(){
        super();
    }
    public Dept(Long id,Long fid,String name){
        this.id=id;this.name=name;this.fid=fid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }
}
