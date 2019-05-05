package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "taskflow")
public class TaskFlow implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String proposer;
    private Date applytime;
    private Byte applytype;
    @Column(length = 500)
    private String reason;
    @Column(length = 50)
    private String attachmentpath;
    private Byte approvestatus;
    @Column(length = 50)
    private String approver;
    private String comments;
    private Byte status;
    private Date createtime;
    private Date modifiedtime;
    public TaskFlow(){
        super();
    }
    public TaskFlow(Long id,String proposer,Date applytime,Byte applytype,String reason,String attachmentpath,Byte approvestatus,String approver,String comments,Byte status,Date createtime,Date modifiedtime){
        this.id=id;this.proposer=proposer;this.applytime=applytime;this.applytype=applytype;this.reason=reason;this.attachmentpath=attachmentpath;this.approvestatus=approvestatus;this.approver=approver;this.comments=comments;this.status=status;this.createtime=createtime;this.modifiedtime=modifiedtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Byte getApplytype() {
        return applytype;
    }

    public void setApplytype(Byte applytype) {
        this.applytype = applytype;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAttachmentpath() {
        return attachmentpath;
    }

    public void setAttachmentpath(String attachmentpath) {
        this.attachmentpath = attachmentpath;
    }

    public Byte getApprovestatus() {
        return approvestatus;
    }

    public void setApprovestatus(Byte approvestatus) {
        this.approvestatus = approvestatus;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
