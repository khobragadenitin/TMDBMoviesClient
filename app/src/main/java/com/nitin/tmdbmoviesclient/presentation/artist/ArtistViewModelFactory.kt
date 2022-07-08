package com.nitin.tmdbmoviesclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.nitin.tmdbmoviesclient.domain.usecase.GetArtistUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpadteArtistUseCase


class ArtistViewModelFactory(
    val getArtistUseCase: GetArtistUseCase,
    val updateArtistUseCase: UpadteArtistUseCase) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updateArtistUseCase) as T
    }

}