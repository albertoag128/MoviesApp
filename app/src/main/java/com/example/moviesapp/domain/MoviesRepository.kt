package com.example.moviesapp.domain

interface MoviesRepository {
    suspend fun getAllMovies(): List<Movie>
    suspend fun getMovieById(id:String):Movie?
}