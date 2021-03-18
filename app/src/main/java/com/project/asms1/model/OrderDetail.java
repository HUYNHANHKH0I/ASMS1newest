package com.project.asms1.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    @SerializedName("productname")
    @Expose
    private String productname;
    @SerializedName("imgurl")
    @Expose
    private String imgurl;
    @SerializedName("quantity")
    @Expose
    private int Quantity;
    @SerializedName("totalprice")
    @Expose
    private float Price;

    public String getProductname() {
        return productname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public int getQuantity() {
        return Quantity;
    }

    public float getPrice() {
        return Price;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
