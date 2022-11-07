package com.example.moviesapp.domain

class GetSingleMovieUseCase(val repository: MoviesRepository){

    fun execute(id:String):MovieDetail{
        val movie = repository.getMovieById(id)!!
        return MovieDetail(
            movie.poster,
            movie.title,
            movie.plot,
            movie.genre,
            movie.rating,
            movie.year
        )
    }
}

data class MovieDetail(val poster:String, val title:String, val plot:String, val genre:String, val rating: String, val year:String)