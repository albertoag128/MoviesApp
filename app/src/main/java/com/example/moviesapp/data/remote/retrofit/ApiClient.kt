package com.example.moviesapp.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    val baseUrl:String = "https://movies-and-shows-api.cyclic.app/"
    var apiEndPoints:ApiEndPoints

    init {
        apiEndPoints = buildApiEndPoints()
    }

    fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun buildApiEndPoints():ApiEndPoints{
        return buildClient().create(ApiEndPoints::class.java)
    }

    fun getAllMovies():List<MovieApiModel>{
        val response = apiEndPoints.getAllMovies().execute()
        if(response.isSuccessful){
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    fun getMovieById(id:String):MovieApiModel?{
        val response = apiEndPoints.getMovieById(id).execute()
        if(response.isSuccessful){
            return response.body() ?: null
        }
        return null
    }

}