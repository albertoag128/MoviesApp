package com.example.moviesapp.data.local

import com.example.moviesapp.domain.Movie

interface MoviesLocalDataRepository {
    fun getAllMovies():List<Movie>
    fun getMovieById(id:String):Movie?
    fun saveMovies(list:List<Movie>)
}