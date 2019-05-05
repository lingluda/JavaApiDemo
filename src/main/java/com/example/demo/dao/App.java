package com.example.demo.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "app")
public class App implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String imgSrc;
    @Column(length = 50)
    private String href;
    private Boolean isMine = false;
    private Byte status;
    private Date createtime;
    private Date modifiedtime;
    public App(){
        super();
    }
    public App(String imgsrc,Long id,String name,String icon,Boolean ismine,Byte status,Date createtime,Date modifiedtime){
        this.href=href;this.id=id;this.name=name;this.imgSrc=imgSrc;this.isMine=isMine;this.status=status;this.createtime=createtime;this.modifiedtime=modifiedtime;
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getIsMine() {
        return isMine;
    }

    public void setIsMine(Boolean isMine) {
        this.isMine = isMine;
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
}
