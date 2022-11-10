package com.example.moviesapp.data.local.room

import android.content.Context
import androidx.room.Room
import com.example.app.roomDb.AppDatabase
import com.example.moviesapp.data.local.MoviesLocalDataRepository
import com.example.moviesapp.domain.Movie

class MovieRoomLocalDataSource (val daoMoviesDao: MoviesDao):MoviesLocalDataRepository{

    override fun getAllMovies(): List<Movie> {
        return daoMoviesDao.getAllMovies().map {
            it.toDomain()
        }
    }

    override fun getMovieById(id: String): Movie? {
        return daoMoviesDao.findMovieById(id)?.toDomain()
    }

    override fun saveMovies(list: List<Movie>) {
        val entities = list.map {
            it.toEntity()
        }
        daoMoviesDao.save(*entities.toTypedArray())
    }
}