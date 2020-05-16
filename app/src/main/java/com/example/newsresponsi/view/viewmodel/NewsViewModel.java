package com.example.newsresponsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsresponsi.model.news.ArticlesItem;
import com.example.newsresponsi.model.news.NewsResponse;
import com.example.newsresponsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<ArticlesItem>> listNews = new MutableLiveData<>();
    public void setNews(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiNews().getNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse response_news = response.body();
                if (response_news != null && response_news.getArticles() != null){
                    ArrayList<ArticlesItem> article_items = response_news.getArticles();
                    listNews.postValue(article_items);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<ArticlesItem>> getNews(){
        return listNews;
    }
}
