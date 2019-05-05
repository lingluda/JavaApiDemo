package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "note")
public class Note implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 60)
    private String title;
    @Column(length = 600)
    private String content;
    private Byte isnew;
    private Byte status;
    private Date createtime;
    private Date modifiedtime;

    public Note(){
        super();
    }
    public Note(Long id, String title, String content, Byte isnew, Byte status, Date createtime, Date modifiedtime){
        this.id=id;this.title=title;this.content=content;this.isnew=isnew;this.status=status;this.createtime=createtime;this.modifiedtime=modifiedtime;
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

    public Byte getIsnew() {
        return isnew;
    }

    public void setIsnew(Byte isnew) {
        this.isnew = isnew;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }
}
