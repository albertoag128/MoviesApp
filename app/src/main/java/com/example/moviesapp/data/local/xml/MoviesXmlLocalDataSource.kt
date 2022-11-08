package com.example.moviesapp.data.local.xml

import android.content.SharedPreferences
import com.example.app.commons.KSerializer
import com.example.moviesapp.data.local.MoviesLocalDataRepository
import com.example.moviesapp.domain.Movie

class MoviesXmlLocalDataSource (private val sharedPreferences: SharedPreferences, private val serializer:KSerializer): MoviesLocalDataRepository{

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    override fun getAllMovies(): List<Movie> {
        val list = mutableListOf<Movie>()
        sharedPreferences.all.forEach {
            editor.apply {
                list.add(serializer.fromJson(it.value as String, Movie::class.java))
            }.apply()
        }
        return list
    }

    override fun getMovieById(id: String): Movie {
        return sharedPreferences.getString(id, null).let{
            serializer.fromJson(it, Movie::class.java)
        }
    }

    override fun saveMovies(list: List<Movie>) {
        list.forEach {
            editor.putString(it.id, serializer.toJson(it, Movie::class.java))
        }
        editor.apply()
    }

}