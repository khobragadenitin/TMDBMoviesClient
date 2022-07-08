package com.nitin.tmdbmoviesclient.presentation.di.artiist

import com.nitin.tmdbmoviesclient.domain.usecase.GetArtistUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpadteArtistUseCase
import com.nitin.tmdbmoviesclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        upadteArtistUseCase: UpadteArtistUseCase
    ): ArtistViewModelFactory = ArtistViewModelFactory(getArtistUseCase,upadteArtistUseCase)
}