package com.example.demo.dao.base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "college")
public class College implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String name;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "fid")
    private List<Dept> deptList;
    public College(){
        super();
    }
    public College(Long id,String name,List<Dept> deptList){
        this.id =id;this.name=name;this.deptList=deptList;
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

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }
}
