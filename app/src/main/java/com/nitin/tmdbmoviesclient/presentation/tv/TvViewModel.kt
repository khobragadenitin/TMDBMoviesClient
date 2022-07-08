package com.nitin.tmdbmoviesclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nitin.tmdbmoviesclient.domain.usecase.GetTVShowUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpdateTVShowUseCase

class TvViewModel(private val getTVShowUseCase: GetTVShowUseCase,
private val updateTVShowUseCase: UpdateTVShowUseCase): ViewModel() {


    fun getTvShows() = liveData {
        val tvshowList = getTVShowUseCase.execute()
        emit(tvshowList)
    }

    fun updateTvShows() = liveData {
        val tvshowList = getTVShowUseCase.execute()
        emit(tvshowList)
    }
}