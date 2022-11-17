package com.example.moviesapp.domain

class GetSingleMovieUseCase(private val repository: MoviesRepository){

    suspend fun execute(id:String):MovieDetail{
        val movie = repository.getMovieById(id)!!
        return MovieDetail(
            movie.title,
            movie.plot,
            movie.genre,
            movie.rating,
            movie.year
        )
    }

    data class MovieDetail(val title:String, val plot:String, val genre:String, val rating: String, val year:String)
}

