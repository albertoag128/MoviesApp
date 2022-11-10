package com.example.moviesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.domain.GetMoviesFeedUseCase

class MoviesAdapter: RecyclerView.Adapter<MoviesViewHolder>(){

    private val dataSet = mutableListOf<GetMoviesFeedUseCase.MoviesFeed>()
    private var item: ((String) -> Unit)? = null

    /*fun setOnClickItem(item: (String) -> Unit) {
        this.item = item
    }*/

    fun setDataItems(movies: List<GetMoviesFeedUseCase.MoviesFeed>){
        dataSet.clear()
        dataSet.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_movies_item_list, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(dataSet[position], item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}