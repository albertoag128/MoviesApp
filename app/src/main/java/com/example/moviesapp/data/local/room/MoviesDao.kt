package com.example.moviesapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface MoviesDao{
    @Query("SELECT * FROM $MOVIES_TABLE_NAME")
    fun getAllMovies():List<MoviesEntity>

    @Insert(onConflict = REPLACE)
    fun save(vararg movies:MoviesEntity)

    @Query("SELECT * FROM $MOVIES_TABLE_NAME WHERE $MOVIES_ID = :movieId")
    fun findMovieById(movieId:String):MoviesEntity?

    @Delete
    fun delete(movie:MoviesEntity)
}