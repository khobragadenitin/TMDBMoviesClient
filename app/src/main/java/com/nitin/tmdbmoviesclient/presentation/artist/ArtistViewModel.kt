package com.nitin.tmdbmoviesclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nitin.tmdbmoviesclient.domain.usecase.GetArtistUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpadteArtistUseCase

class ArtistViewModel(
    val getArtistUseCase: GetArtistUseCase,
    val updateArtistUseCase: UpadteArtistUseCase) : ViewModel() {

        fun getArtist() = liveData {
            val artistList = getArtistUseCase.execute()
            emit(artistList)
        }

    fun updateArtist() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}