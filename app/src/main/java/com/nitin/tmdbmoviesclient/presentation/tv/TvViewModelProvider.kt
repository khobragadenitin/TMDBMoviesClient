package com.nitin.tmdbmoviesclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nitin.tmdbmoviesclient.domain.usecase.GetTVShowUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpdateTVShowUseCase

class TvViewModelProvider(private val getTVShowUseCase: GetTVShowUseCase,
private val updateTVShowUseCase: UpdateTVShowUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTVShowUseCase, updateTVShowUseCase) as T
    }
}