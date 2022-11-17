package com.example.moviesapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieDetailsBinding
import com.example.moviesapp.domain.GetSingleMovieUseCase

class MovieDetailFragment : Fragment() {
    private var viewModel: MovieDetailViewModel? = null
    private var binding: FragmentMovieDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MoviesFactory().getMovieDetailViewModel(
            requireContext()
        )
        setupObservers()
        viewModel?.loadSingleMovie(getMovieId())
    }

    private fun setupObservers() {
        val movieDetailSuscriber =
            Observer<MovieDetailViewModel.MovieUiState> { uiState ->
                uiState.movie?.let {
                    bind(it)
                }
            }
        viewModel?.moviesDetailPublisher?.observe(viewLifecycleOwner, movieDetailSuscriber)
    }

    private fun getMovieId(): String = arguments?.getString("key_movie") ?: "a"

    private fun bind(model: GetSingleMovieUseCase.MovieDetail) {
        binding?.apply {
            detailMovieTitle.text = model.title
            detailMovieGenre.text = model.genre
            detailMoviePlot.text = model.plot
            detailMovieYear.text = model.year
            detailMovieRating.text = model.rating
        }
    }

}