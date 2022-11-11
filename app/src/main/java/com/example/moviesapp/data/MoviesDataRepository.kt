package com.example.moviesapp.data

import com.example.moviesapp.data.local.room.MovieDbLocalDataSource
import com.example.moviesapp.data.remote.retrofit.MovieApiRemoteDataSource
import com.example.moviesapp.domain.Movie
import com.example.moviesapp.domain.MoviesRepository

class MoviesDataRepository (
    private val localSource: MovieDbLocalDataSource,
    private val remoteSource: MovieApiRemoteDataSource) : MoviesRepository{


    override suspend fun getAllMovies(): List<Movie> {
        var movies = localSource.getAllMovies()
        if(movies.isNullOrEmpty()){
            movies = remoteSource.getAllMovies()
            localSource.saveMovies(movies)
            return movies
        }
        return movies
    }

    override suspend fun getMovieById(id: String): Movie? {
        var movie = localSource.getMovieById(id)
        if(movie == null){
            movie = remoteSource.getMovieById(id)
            return movie
        }
        return movie
    }

}