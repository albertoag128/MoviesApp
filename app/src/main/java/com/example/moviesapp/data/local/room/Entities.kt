package com.example.moviesapp.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val MOVIES_TABLE_NAME = "movies"
const val MOVIES_ID = "id"

@Entity(tableName = MOVIES_TABLE_NAME)
data class MoviesEntity(
    @PrimaryKey @ColumnInfo (name = MOVIES_ID) val id:String,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "plot") val plot:String,
    @ColumnInfo(name = "genre") val genre:String,
    @ColumnInfo(name = "rating") val rating:String,
    @ColumnInfo(name = "year") val year:String,
    @ColumnInfo(name = "poster") val poster:String
)