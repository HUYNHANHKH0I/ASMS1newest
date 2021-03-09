package com.project.asms1.network.service;

import com.project.asms1.model.Product;
import com.project.asms1.model.Token;
import com.project.asms1.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Philippe on 02/03/2018.
 */

public interface APIService {
    @GET("/getuser")
    Call<User> getUser();

    @GET("getProdcuts")
    Call<List<Product>> getProduct();

    @POST("Users/login")
    Call<User> Login(@Body User user);

    @POST("Users/loadinguser")
    Call<Token> Loading(@Body Token tokens);
}
