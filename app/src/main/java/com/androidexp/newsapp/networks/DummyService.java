package com.androidexp.newsapp.networks;

import com.androidexp.newsapp.model.AllNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DummyService {

    @GET("top-headlines")
    Call<AllNews> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category
    );

    @GET("top-headlines")
    Call<AllNews> getNews(
            @Query("country") String country
    );
}
