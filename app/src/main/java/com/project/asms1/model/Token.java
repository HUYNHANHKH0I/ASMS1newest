package com.project.asms1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Token {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("productperpage")
    @Expose
    private int productPerPage;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("productslist")
    @Expose
    private List<Product> listProducts;
    @SerializedName("sumofpages")
    @Expose
    private int numberOfPage;

    public User getUser() {
        return user;
    }

    public int getProductperpage() {
        return productPerPage;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public String getToken() {
        return token;
    }

    public String getResult() {
        return result;
    }


    public Token(String token, int productperpage) {
        this.token = token;
        this.productPerPage = productperpage;
    }
}
