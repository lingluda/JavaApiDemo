package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_product")
public class Product implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long p_price;
    private Long p_rating;
    private String p_desc;
    private Long p_fatherId;
   /* @OneToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "")*/
   // private Comment comment;
    public Product(){
        super();
    }

    public Product(Long id,String name,Long p_price,Long p_rating,String p_desc,Long p_fatherId){
        super();
        this.id = id;
        this.name = name;
        this.p_desc =p_desc;
        this.p_price =p_price;
        this.p_rating =p_rating;
        this.p_fatherId =p_fatherId;
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

    public Long getP_price() {
        return p_price;
    }

    public void setP_price(Long p_price) {
        this.p_price = p_price;
    }

    public Long getP_rating() {
        return p_rating;
    }

    public void setP_rating(Long p_rating) {
        this.p_rating = p_rating;
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
