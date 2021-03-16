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

    public int getSumofpages() {
        return sumofpages;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public Store() {
    }
}
