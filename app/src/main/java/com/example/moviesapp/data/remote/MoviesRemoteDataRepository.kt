package com.example.moviesapp.data.remote

import com.example.moviesapp.domain.Movie

interface MoviesRemoteDataRepository {
    suspend fun getAllMovies():List<Movie>
    suspend fun getMovieById(id:String):Movie?
}