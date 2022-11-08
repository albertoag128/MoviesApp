package com.example.moviesapp.data.remote.retrofit

import com.example.moviesapp.data.remote.MoviesRemoteDataRepository
import com.example.moviesapp.domain.Movie

class MovieRetrofitRemoteDataSource (val client: ApiClient) : MoviesRemoteDataRepository{

    override fun getAllMovies(): List<Movie> {
        return client.getAllMovies().map {
            it.toDomain()
        }
    }

    override fun getMovieById(id: String): Movie? {
        return client.getMovieById(id)?.toDomain()
    }

}