package com.example.newsresponsi.service;

import com.example.newsresponsi.model.news.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsRepository {
    @GET("v2/top-headlines?sources=bbc-news&apiKey=eb9357241e06459182f7150979946b98")
    Call<NewsResponse> getNews();
}
