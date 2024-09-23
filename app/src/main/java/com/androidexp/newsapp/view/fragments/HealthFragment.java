package com.androidexp.newsapp.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidexp.newsapp.NewsClick.IONewsClick;
import com.androidexp.newsapp.R;
import com.androidexp.newsapp.adapter.NewsAdapter;
import com.androidexp.newsapp.dummyPresenter.DummyPresenters;
import com.androidexp.newsapp.interfaces.GetAllNewsView;
import com.androidexp.newsapp.model.AllNews;
import com.androidexp.newsapp.model.Article;
import com.androidexp.newsapp.view.ItemTabActivity;

import java.util.ArrayList;

public class HealthFragment extends Fragment implements GetAllNewsView {

    private RecyclerView recyclerViewHealth;
    private NewsAdapter newsAdapter;
    private DummyPresenters dummyPresenters;

    private ArrayList<Article> mListData;

    private AllNews allNews;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_heath_fragment,container, false);
        recyclerViewHealth = v.findViewById(R.id.recyclerViewHealth);

        dummyPresenters = new DummyPresenters();
        dummyPresenters.setGetAllNewsViewCallBack(this);

        initData();
        initView();

        dummyPresenters.getCategoryNews("health");
        return v;
    }

    private void initData() {
        mListData = new ArrayList<>();
    }

    private void initView() {
        newsAdapter = new NewsAdapter(mListData, new IONewsClick() {
            @Override
            public void onNewsItemClick(Article article) {
                Intent intent = new Intent(getContext(), ItemTabActivity.class);
                intent.putExtra("url", article.getUrl());
                startActivity(intent);
            }
        });
        recyclerViewHealth.setAdapter(newsAdapter);
        recyclerViewHealth.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onGetAllNewsSuccess(AllNews response) {
        if (response != null && response.getArticles() != null && !response.getArticles().isEmpty()) {
            this.allNews = response;
            mListData.clear();
            mListData.addAll(response.getArticles());
            newsAdapter.notifyDataSetChanged();
        } else {
            Log.d("TAG", "No articles found or response is null");
        }
    }

    @Override
    public void onGetAllNewsFailed(String message) {
        Log.d("TAG", "onGetAllNewsFailed: "+message);
    }

}