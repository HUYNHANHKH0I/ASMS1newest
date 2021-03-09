package com.project.asms1.network;

import com.project.asms1.config.MyConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkProvider {

    private static volatile NetworkProvider mInstance = null;

    private Retrofit retrofit;
    public String user;

    private NetworkProvider() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyConfig.baseHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkProvider self() {
        if (mInstance == null)
            mInstance = new NetworkProvider();
        return mInstance;
    }

    public <T> T getService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }

}