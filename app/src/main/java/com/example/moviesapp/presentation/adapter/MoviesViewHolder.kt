package com.example.moviesapp.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.app.extensions.loadUrl
import com.example.moviesapp.databinding.ActivityMoviesItemListBinding
import com.example.moviesapp.domain.GetMoviesFeedUseCase

class MoviesViewHolder(private val view: View): RecyclerView.ViewHolder(view){
    fun bind(movie: GetMoviesFeedUseCase.MoviesFeed, item: ((String) -> Unit)?){
        val binding = ActivityMoviesItemListBinding.bind(view)
        binding.imageItem.loadUrl(movie.poster)
        binding.filmTitleItem.text = movie.title
        binding.year.text = movie.year
        binding.rating.text = movie.rating
        /*view.setOnClickListener {
            item?.invoke(movie.id)
        }*/
    }
}