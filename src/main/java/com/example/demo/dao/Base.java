package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "base")
public class Base implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 100)
    private String name;
    private Byte type;
    private Byte status;
    private Date createtime;
    private Date modifiedtime;

    public Base(){
        super();
    }
    public Base(Long id, String name, Byte type, Byte status, Date createtime, Date modifiedtime){
        this.id = id;this.name = name;this.type = type;this.status = status;this.createtime=createtime;this.modifiedtime=modifiedtime;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}
