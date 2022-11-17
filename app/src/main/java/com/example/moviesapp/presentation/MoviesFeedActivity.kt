package com.example.moviesapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.moviesapp.databinding.ActivityMoviesFeedListBinding

class MoviesFeedActivity : AppCompatActivity() {

    private var binding: ActivityMoviesFeedListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    fun setupBinding(){
        binding = ActivityMoviesFeedListBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }
}