package com.androidexp.newsapp.networks;

import com.androidexp.newsapp.MyApplication;
import com.androidexp.newsapp.constants.ConstantApi;
import com.chuckerteam.chucker.api.ChuckerInterceptor;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitClient {
    public static Retrofit instances;


    private static OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Authorization", "Bearer a4fca8f335be444ab77017bdbd7ddc0c")
                            .build();
                    return chain.proceed(request);
                })
                .addInterceptor(new ChuckerInterceptor(MyApplication.getInstances().getApplicationContext()))
                .build();
    }


    public static Retrofit getInstances() {
        if (instances == null) {
            instances = new Retrofit.Builder()
                    .baseUrl(ConstantApi.BASE_URL)
                    .client(getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instances;
    }

    public static DummyService getDummyService() {
        return getInstances().create(DummyService.class);
    }
}
