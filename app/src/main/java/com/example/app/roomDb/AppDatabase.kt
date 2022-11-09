package com.example.app.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.data.local.room.MoviesDao
import com.example.moviesapp.data.local.room.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,AppDatabase::class.java, "movies-room-db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}