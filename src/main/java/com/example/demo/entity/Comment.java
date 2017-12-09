package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_comment")
public class Comment implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
   // @OneToOne(optional = false,mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Long productId;
    private String timetamp;
    private String user;
    private Long rating;
    private String content;
    public Comment(){
        super();
    }
    public Comment(Long id,Long productId,String timetamp,String user, Long rating, String content){
        super();
        this.id =id;
        this.productId=productId;
        this.timetamp=timetamp;
        this.user=user;
        this.rating=rating;
        this.content=content;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(String timetamp) {
        this.timetamp = timetamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
