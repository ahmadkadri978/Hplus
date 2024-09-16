package com.rest.hplus.beans;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "image_path")
    private String image_path;
    @Column(name = "order_date")
    private Date order_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(){}

    public Order(String product_name, String image_path, Date order_date, User user) {
        this.product_name = product_name;
        this.image_path = image_path;
        this.order_date = order_date;
        this.user = user;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
