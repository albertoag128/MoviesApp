package com.example.moviesapp.data.remote.retrofit

import com.example.moviesapp.domain.Movie

fun MovieApiModel.toDomain(): Movie {
    return Movie(this.id, this.title, this.plot, this.genre, this.rating, this.year, this.poster)
}