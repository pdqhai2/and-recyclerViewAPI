package com.example.recylerviewapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("newsapi")
    Call<List<Article>> getAllNews();
}
