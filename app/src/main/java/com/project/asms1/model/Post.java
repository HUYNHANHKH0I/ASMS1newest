package com.project.asms1.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Date;

public class Post implements Serializable {
    @SerializedName("id")
    @Expose
    private String ID;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("time")
    @Expose
    private Date time;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("storeID")
    @Expose
    private String storeID;
    @SerializedName("totalOrder")
    @Expose
    private int totalOrder;

    public String getID() {
        return ID;
    }

    public String getStoreID() {
        return storeID;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
