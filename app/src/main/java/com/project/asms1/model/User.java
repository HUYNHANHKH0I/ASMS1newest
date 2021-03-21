package com.project.asms1.model;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class User implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("idrole")
    @Expose
    private int role;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("productslist")
    @Expose
    private List<Product> productslist;
    @SerializedName("categorylist")
    @Expose
    private List<Category> categorylist;
    @SerializedName("sumofpages")
    @Expose
    private int numberOfPage;
    @SerializedName("productperpage")
    @Expose
    private int productperpage;
    @SerializedName("create")
    @Expose
    private Date create;
    @SerializedName("update")
    @Expose
    private Date update;
    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreate() {
        return create;
    }

    public Date getUpdate() {
        return update;
    }

    public List<Category> getCategorylist() {
        return categorylist;
    }

    public List<Product> getProductslist() {
        return productslist;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public User(String password, String username,int productperpage ) {
        this.password = password;
        this.username = username;
        this.productperpage = productperpage;
    }

    public User(String password, String username,String name, String email, int roleid ) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.name = name;
        this.role = roleid;
    }
}
