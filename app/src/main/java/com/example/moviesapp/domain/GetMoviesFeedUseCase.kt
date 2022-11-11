package com.example.moviesapp.domain

class GetMoviesFeedUseCase(private val repository: MoviesRepository) {
    suspend fun execute():List<MoviesFeed>{
        val movies = repository.getAllMovies()

        val moviesList = movies.map {
            MoviesFeed(
                it.poster,
                it.title,
                it.year,
                it.rating,
                it.id
            )
        }
        return moviesList
    }

    data class MoviesFeed(val poster:String, val title:String, val year:String, val rating:String, val id:String)
}

