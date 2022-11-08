package com.example.moviesapp.domain

interface MoviesRepository {
    fun getAllMovies(): List<Movie>
    fun getMovieById(id:String):Movie?
}