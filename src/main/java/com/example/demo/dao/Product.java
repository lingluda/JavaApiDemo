
package com.example.demo.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn
    private User user;
    private String name;
    private Long price;
    private Long rating;
    private String p_desc;
    private Long p_fatherId;
    public Product(){
        super();
    }

    public Product(Long id,String name,Long price,Long rating,String p_desc,Long p_fatherId){
        super();
        this.id = id;
        this.name = name;
        this.p_desc =p_desc;
        this.price =price;
        this.rating =rating;
        this.p_fatherId =p_fatherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getP_desc() {
        return p_desc;
    }

    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public Long getP_fatherId() {
        return p_fatherId;
    }

    public void setP_fatherId(Long p_fatherId) {
        this.p_fatherId = p_fatherId;
    }
}

