package com.example.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.GetMoviesFeedUseCase
import com.example.moviesapp.domain.GetSingleMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel (private val getSingleMovieUseCase: GetSingleMovieUseCase) : ViewModel(){

    val moviesDetailPublisher: MutableLiveData<MovieUiState> by lazy{
        MutableLiveData<MovieUiState>()
    }

    fun loadSingleMovie(id:String){
        moviesDetailPublisher.value = MovieUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val singleMovie = getSingleMovieUseCase.execute(id)
            moviesDetailPublisher.postValue(
                MovieUiState(
                    isLoading = false,
                    movie = singleMovie
                )
            )
        }
    }

    data class MovieUiState(
        val isLoading:Boolean = false,
        val movie: GetSingleMovieUseCase.MovieDetail? = null
    )

}