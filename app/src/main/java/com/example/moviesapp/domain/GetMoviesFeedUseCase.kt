package com.example.moviesapp.domain

class GetMoviesFeedUseCase(val repository: MoviesRepository) {
    fun execute():List<MoviesFeed>{
        val movies = repository.getAllMovies()

        val moviesList = movies.map {
            MoviesFeed(
                it.poster,
                it.title,
                it.year,
                it.rating
            )
        }
        return moviesList
    }
}

data class MoviesFeed(val poster:String, val title:String, val year:String, val rating:String)