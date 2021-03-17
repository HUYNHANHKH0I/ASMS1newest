package com.project.asms1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Store {
    @SerializedName("productslist")
    @Expose
    private List<Product> listProducts;
    @SerializedName("sumofpages")
    @Expose
    private int sumofpages;
    @SerializedName("result")
    @Expose
    private String result;

    public int getSumofpages() {
        return sumofpages;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public String getResult() {
        return result;
    }

    public Store() {
    }
}
