package com.nitin.tmdbmoviesclient.presentation.di.core

import com.nitin.tmdbmoviesclient.domain.repository.ArtistRepository
import com.nitin.tmdbmoviesclient.domain.repository.MovieRepository
import com.nitin.tmdbmoviesclient.domain.repository.TvShowRepository
import com.nitin.tmdbmoviesclient.domain.usecase.*
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUsecase(movieRepository: MovieRepository) : GetMovieUseCase = GetMovieUseCase(movieRepository)

    @Provides
    fun provideUpdateMovieUsecase(movieRepository: MovieRepository) : UpdateMovieUseCase = UpdateMovieUseCase(movieRepository)


    @Provides
    fun provideGetArtistUsecase(artistRepository: ArtistRepository) : GetArtistUseCase = GetArtistUseCase(artistRepository)


    @Provides
    fun provideUpdateArtistUsecase(artistRepository: ArtistRepository) : UpadteArtistUseCase = UpadteArtistUseCase(artistRepository)


    @Provides
    fun provideGetTvShowUsecase(tvShowRepository: TvShowRepository) : GetTVShowUseCase = GetTVShowUseCase(tvShowRepository)

    @Provides
    fun provideUpdateTvShowUsecase(tvShowRepository: TvShowRepository) : UpdateTVShowUseCase = UpdateTVShowUseCase(tvShowRepository)




}