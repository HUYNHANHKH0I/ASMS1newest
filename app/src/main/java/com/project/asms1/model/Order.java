package com.project.asms1.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Order implements Serializable {
    private String ID, CustomerID,PostID;
    private int Status;
    private LocalDateTime OrderDate;

    public Order(String ID, String customerID, String postID, int status, LocalDateTime orderDate) {
        this.ID = ID;
        CustomerID = customerID;
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

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
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

    public LocalDateTime getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        OrderDate = orderDate;
    }
}
