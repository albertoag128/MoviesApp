package com.example.moviesapp.data

import com.example.moviesapp.data.local.room.MovieRoomLocalDataSource
import com.example.moviesapp.data.remote.firebase.MoviesFirebaseRemoteDataSource
import com.example.moviesapp.data.remote.retrofit.MovieRetrofitRemoteDataSource
import com.example.moviesapp.domain.Movie
import com.example.moviesapp.domain.MoviesRepository

class MoviesDataRepository (
    private val localSource: MovieRoomLocalDataSource,
    private val remoteSource: MovieRetrofitRemoteDataSource) : MoviesRepository{


    override suspend fun getAllMovies(): List<Movie> {
        if(localSource.getAllMovies().isNullOrEmpty()){
            val movies = remoteSource.getAllMovies()
            localSource.saveMovies(movies)
            return movies
        }
        return localSource.getAllMovies()
    }

    override suspend fun getMovieById(id: String): Movie? {
        if(localSource.getMovieById(id)==null){
            return remoteSource.getMovieById(id)
        }
        return localSource.getMovieById(id)
    }

}