package com.example.moviesapp.data.local.memory

import com.example.app.commons.MemoryDataStore
import com.example.moviesapp.data.local.MoviesLocalDataRepository
import com.example.moviesapp.domain.Movie

class MoviesMemoryLocalDataSource (private val memoryDataStore: MemoryDataStore<Movie>): MoviesLocalDataRepository{

    override fun getAllMovies(): List<Movie> {
        return memoryDataStore.getAll()
    }

    override fun getMovieById(id: String): Movie? {
        return memoryDataStore.getById(id)
    }

    override fun saveMovies(list: List<Movie>) {
        list.forEach {
            memoryDataStore.put(it.id, it)
        }
    }

}