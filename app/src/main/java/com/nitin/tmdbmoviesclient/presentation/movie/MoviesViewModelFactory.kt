package com.nitin.tmdbmoviesclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nitin.tmdbmoviesclient.domain.usecase.GetMovieUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpdateMovieUseCase

class MoviesViewModelFactory(private val getMovieUseCase: GetMovieUseCase,
private val updateMovieUseCase: UpdateMovieUseCase):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase, updateMovieUseCase) as T
    }

}