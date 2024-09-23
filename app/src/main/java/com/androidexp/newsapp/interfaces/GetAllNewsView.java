package com.androidexp.newsapp.interfaces;

import com.androidexp.newsapp.model.AllNews;

public interface GetAllNewsView {

    void onGetAllNewsSuccess(AllNews allNews);

    void onGetAllNewsFailed(String message);
}
