package com.example.moviefinder.remote;

import com.example.moviefinder.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("/")
    Call<ResponseMovie> getMovieList(@Query("t") String keyword, @Query("apiKey")  String apiKey);
}

