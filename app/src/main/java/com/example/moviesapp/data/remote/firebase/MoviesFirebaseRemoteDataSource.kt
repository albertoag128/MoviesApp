package com.example.moviesapp.data.remote.firebase

import com.example.moviesapp.data.remote.MoviesRemoteDataRepository
import com.example.moviesapp.domain.Movie
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class MoviesFirebaseRemoteDataSource: MoviesRemoteDataRepository {

    override suspend fun getAllMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        val database = Firebase.database.reference
        val snapshots = database.get().await()

        snapshots.children.forEach {
            it.getValue(MovieFirebaseModels::class.java)?.let { movie->
                movies.add(movie.toDomain())
            }
        }
        return movies
    }

    override suspend fun getMovieById(id: String): Movie? {
        val database = Firebase.database.reference.child(id)
        val snapshots = database.get().await()
        return snapshots.getValue(MovieFirebaseModels::class.java)?.toDomain()
    }

}