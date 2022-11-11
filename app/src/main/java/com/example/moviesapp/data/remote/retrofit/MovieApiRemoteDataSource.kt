package com.example.moviesapp.data.remote.retrofit

import com.example.moviesapp.data.remote.MoviesRemoteDataRepository
import com.example.moviesapp.domain.Movie

class MovieApiRemoteDataSource (val client: ApiClient) : MoviesRemoteDataRepository{

    override suspend fun getAllMovies(): List<Movie> {
        return client.getAllMovies().map {
            it.toDomain()
        }
    }

    override suspend fun getMovieById(id: String): Movie? {
        return client.getMovieById(id)?.toDomain()
    }

}