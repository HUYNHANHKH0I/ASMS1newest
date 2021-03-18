package com.project.asms1.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements Serializable {
    @SerializedName("id")
    @Expose
    private String ID;
    @SerializedName("postID")
    @Expose
    private String PostID;
    @SerializedName("orderdetaillist")
    @Expose
    private List<OrderDetail> orderdetaillist;
    @SerializedName("customerinfo")
    @Expose
    private Customer customerinfo;
    @SerializedName("status")
    @Expose
    private int Status;
    @SerializedName("totalPrice")
    @Expose
    private float totalPrice;
    @SerializedName("orderDate")
    @Expose
    private Date OrderDate;


    public float getTotalPrice() {
        return totalPrice;
    }

    public String getID() {
        return ID;
    }

    public String getPostID() {
        return PostID;
    }

    public List<OrderDetail> getOrderdetaillist() {
        return orderdetaillist;
    }

    public Customer getCustomerinfo() {
        return customerinfo;
    }

    public int getStatus() {
        return Status;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
