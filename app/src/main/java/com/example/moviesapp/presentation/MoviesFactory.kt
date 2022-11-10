package com.example.moviesapp.presentation

import android.content.Context
import com.example.app.roomDb.AppDatabase
import com.example.moviesapp.data.MoviesDataRepository
import com.example.moviesapp.data.local.room.MovieRoomLocalDataSource
import com.example.moviesapp.data.remote.firebase.MoviesFirebaseRemoteDataSource
import com.example.moviesapp.data.remote.retrofit.ApiClient
import com.example.moviesapp.data.remote.retrofit.MovieRetrofitRemoteDataSource
import com.example.moviesapp.domain.GetMoviesFeedUseCase

class MoviesFactory {


    fun getMoviesFeedViewModel(applicationContext: Context):MoviesFeedViewModel{
        return MoviesFeedViewModel(
            GetMoviesFeedUseCase(
                MoviesDataRepository(
                    MovieRoomLocalDataSource(
                        AppDatabase.getDatabase(applicationContext).moviesDao(),
                    ),
                    MovieRetrofitRemoteDataSource(ApiClient()),
                )
            )
        )
    }


}