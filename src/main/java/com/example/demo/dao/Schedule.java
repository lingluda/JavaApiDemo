package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private Long userid;
    @Column(length = 50)
    private String title;
    @Column(length = 100)
    private String content;
    @Column(length = 50)
    private String address;
    private Date starttime;
    private Date endtime;
    private Byte status;
    private Byte isnew;
    private Date createtime;
    private Date modifiedtime;

    public Schedule(){
        super();
    }
    public Schedule(Byte isnew,Byte status,Date createtime,Date modifiedtime,Long id,Long userid,String title,String content,String address,Date starttime,Date endtime){
        this.isnew = isnew;this.status =status;this.createtime = createtime;this.modifiedtime = modifiedtime;this.id=id;this.userid=userid;this.title=title;this.content=content;this.address=address;this.starttime=starttime;this.endtime=endtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public Byte getIsnew() {
        return isnew;
    }

    public void setIsnew(Byte isnew) {
        this.isnew = isnew;
    }
}
