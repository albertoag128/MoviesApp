package com.example.moviesapp.data.remote.firebase

import com.example.moviesapp.domain.Movie

fun MovieFirebaseModels.toDomain():Movie{
    return Movie(this.id, this.title, this.plot, this.genre,this.rating, this.year, this.poster)
}