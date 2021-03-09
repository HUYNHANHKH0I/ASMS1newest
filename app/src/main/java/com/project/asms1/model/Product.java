package com.project.asms1.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class Product {

    @SerializedName("Id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
