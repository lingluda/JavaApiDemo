package com.example.demo.dao;

import com.example.demo.dao.base.Dept;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String teacherno;
    @OneToOne
    @JoinColumn(name = "deptid")
    private Dept dept;
    @Column(length = 50)
    private String professional;
    @Column(length = 50)
    private String phone;
    private Byte status;
    private Date createtime;
    private Date modifiedtime;
    private String cjh;
    public Teacher(){
        super();
    }
    public Teacher(String cjh,Byte status,Date createtime,Date modifiedtime,Long id,String name,String teacherno,Dept dept,String professional,String phone){
        this.cjh = cjh;this.status=status;this.createtime=createtime;this.modifiedtime=modifiedtime;this.id=id;this.name=name;this.teacherno=teacherno;this.dept=dept;this.professional=professional;this.phone=phone;
    }

    public String getCjh() {
        return cjh;
    }

    public void setCjh(String cjh) {
        this.cjh = cjh;
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

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
