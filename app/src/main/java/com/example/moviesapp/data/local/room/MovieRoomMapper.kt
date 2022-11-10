package com.example.moviesapp.data.local.room

import com.example.moviesapp.domain.Movie

fun MoviesEntity.toDomain():Movie{
    return Movie(this.id, this.title, this.plot, this.genre,
    this.rating, this.year, this.poster)
}

fun Movie.toEntity():MoviesEntity{
    return MoviesEntity(this.id, this.title, this.plot, this.genre,
        this.rating, this.year, this.poster)
}