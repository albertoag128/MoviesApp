package com.example.moviesapp.data.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {

    @GET("movies")
    fun getAllMovies(): Call<List<MovieApiModel>>

    @GET("movies/{id}")
    fun getMovieById(@Path("id") id:String): Call<MovieApiModel?>
}