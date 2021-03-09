package com.project.asms1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("result")
    @Expose
    private String result;

    public String getToken() {
        return token;
    }

    public String getResult() {
        return result;
    }


    public Token(String token) {
        this.token = token;
    }
}
