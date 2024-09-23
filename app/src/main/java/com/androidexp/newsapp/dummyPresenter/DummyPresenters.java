    package com.androidexp.newsapp.dummyPresenter;

    import com.androidexp.newsapp.dummyInteractor.DummyInteractor;
    import com.androidexp.newsapp.interfaces.DummyPresentersImp;
    import com.androidexp.newsapp.interfaces.GetAllNewsView;
    import com.androidexp.newsapp.model.AllNews;

    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;

    public class DummyPresenters implements DummyPresentersImp {

        private DummyInteractor dummyInteractor;
        private GetAllNewsView getAllNewsViewCallBack;

        public void setGetAllNewsViewCallBack(GetAllNewsView getAllNewsViewCallBack) {
            this.getAllNewsViewCallBack = getAllNewsViewCallBack;
        }

        public DummyPresenters() {
            dummyInteractor = DummyInteractor.getInstance();
        }

        @Override
        public void getNews() {
            dummyInteractor.setGetAllNewsCallBack(allNewsCallback);
            dummyInteractor.getNews();
        }

        @Override
        public void getCategoryNews(String category) {
            dummyInteractor.setGetAllNewsCallBack(allNewsCallback);
            dummyInteractor.getCategoryNews(category);
        }


        public Callback<AllNews> allNewsCallback = new Callback<AllNews>() {
            @Override
            public void onResponse(Call<AllNews> call, Response<AllNews> response) {
                if(response.isSuccessful()){
                    getAllNewsViewCallBack.onGetAllNewsSuccess(response.body());
                } else{
                    getAllNewsViewCallBack.onGetAllNewsFailed("Error code"+ response.code());
                }
            }

            @Override
            public void onFailure(Call<AllNews> call, Throwable throwable) {
                getAllNewsViewCallBack.onGetAllNewsFailed("Error"+throwable.getMessage());
            }
        };
    }
