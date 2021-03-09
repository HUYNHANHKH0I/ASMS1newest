package com.project.asms1.model;

import java.io.Serializable;
import java.util.Date;

public class OrderDTO implements Serializable {
    private String ID, OrderDetailID,CustomerID,StoreID,PostID;
    private int Status;
    private Date OrderDate;

    public OrderDTO(String ID, String orderDetailID, String customerID, String storeID, String postID, int status, Date orderDate) {
        this.ID = ID;
        OrderDetailID = orderDetailID;
        CustomerID = customerID;
        StoreID = storeID;
        PostID = postID;
        Status = status;
        OrderDate = orderDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        OrderDetailID = orderDetailID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String postID) {
        PostID = postID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }
}
