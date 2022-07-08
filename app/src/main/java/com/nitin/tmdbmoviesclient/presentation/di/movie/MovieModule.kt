package com.nitin.tmdbmoviesclient.presentation.di.movie

import com.nitin.tmdbmoviesclient.domain.usecase.GetMovieUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpdateMovieUseCase
import com.nitin.tmdbmoviesclient.presentation.movie.MoviesViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMovieUseCase: GetMovieUseCase
                                     ,updateMovieUseCase: UpdateMovieUseCase) : MoviesViewModelFactory{
        return MoviesViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}