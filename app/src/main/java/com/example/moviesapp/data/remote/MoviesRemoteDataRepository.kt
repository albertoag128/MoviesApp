package com.example.moviesapp.data.remote

import com.example.moviesapp.domain.Movie

interface MoviesRemoteDataRepository {
    fun getAllMovies():List<Movie>
    fun getMovieById(id:String):Movie?
}