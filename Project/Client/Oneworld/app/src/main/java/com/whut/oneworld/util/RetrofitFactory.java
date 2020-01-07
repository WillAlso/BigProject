package com.whut.oneworld.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    public static volatile Retrofit retrofit;

    private RetrofitFactory() {
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            synchronized (Retrofit.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(ServerInfo.BASE_URL)
                            .client(OkHttpClientFactory.getInstance())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
