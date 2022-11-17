package com.example.moviesapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMoviesFeedListBinding
import com.example.moviesapp.presentation.adapter.MoviesAdapter
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton

class MoviesFeedFragment : Fragment() {
    private var skeleton:Skeleton?=null
    private var binding: FragmentMoviesFeedListBinding? = null
    private val moviesAdapter = MoviesAdapter()
    val viewModel by lazy {
        MoviesFactory().getMoviesFeedViewModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesFeedListBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadMovies()
    }

    private fun setupView() {
        binding?.apply {
            feedListRecyclerView.apply {
                adapter = moviesAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                moviesAdapter.setOnClickItem {
                    navigateToMovieDetail(it)
                }
                skeleton = applySkeleton(R.layout.activity_movies_item_list)
            }

        }
    }

    private fun setupObservers() {
        val moviesFeedSuscriber =
            Observer<MoviesFeedViewModel.MoviesUiState> { uiState ->
                if (uiState.isLoading) {
                    skeleton?.showSkeleton()
                } else {
                    skeleton?.showOriginal()
                    moviesAdapter.setDataItems(uiState.moviesFeed)
                }
            }
        viewModel.moviesFeedPublisher.observe(viewLifecycleOwner, moviesFeedSuscriber)
    }

    private fun navigateToMovieDetail(movieId:String){
        findNavController().navigate(
            MoviesFeedFragmentDirections.actionMoviesfeedToMoviedetail(movieId)
        )
    }
}