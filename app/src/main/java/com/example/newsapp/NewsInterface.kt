package com.example.newsapp

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("top-headlines")
    fun fetchHeadlines(@Query("country") country:String, @Query("apiKey") apiKey:String): retrofit2.Call<News>

}