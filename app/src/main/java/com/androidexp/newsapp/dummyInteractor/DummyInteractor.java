package com.androidexp.newsapp.dummyInteractor;

import com.androidexp.newsapp.interfaces.DummyInteractorImp;
import com.androidexp.newsapp.model.AllNews;
import com.androidexp.newsapp.networks.DummyService;
import com.androidexp.newsapp.networks.RetrofitClient;

import retrofit2.Callback;
import retrofit2.Retrofit;

public class DummyInteractor implements DummyInteractorImp {

    private static DummyInteractor instances;
    public static DummyService dummyService;
    private Callback<AllNews> getAllNewsCallBack;

    private static final String COUNTRY = "us";
    private static final String API_KEY = "313675e766034d41944e72cab6596484";

//    private static final String CATEGORY_SPORTS = "sports";
//    private static final String CATEGORY_HEALTH = "health";

    public void setGetAllNewsCallBack(Callback<AllNews> getAllNewsCallBack) {
        this.getAllNewsCallBack = getAllNewsCallBack;
    }

    public static DummyInteractor getInstance(){
        if(instances == null){
            instances = new DummyInteractor();
        }
        dummyService = RetrofitClient.getDummyService();
        return instances;
    }

    @Override
    public void getNews() {
        dummyService.getNews(COUNTRY).enqueue(getAllNewsCallBack);
    }

    public void getCategoryNews(String category){
        dummyService.getCategoryNews(COUNTRY, category).enqueue(getAllNewsCallBack);
        //dummyService.getCategoryNews(COUNTRY, CATEGORY_HEALTH, API_KEY).enqueue(getAllNewsCallBack);
    }
}
