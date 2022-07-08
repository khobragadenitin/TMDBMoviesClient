package com.nitin.tmdbmoviesclient.presentation.di.tvshow

import com.nitin.tmdbmoviesclient.domain.usecase.GetTVShowUseCase
import com.nitin.tmdbmoviesclient.domain.usecase.UpdateTVShowUseCase
import com.nitin.tmdbmoviesclient.presentation.tv.TvViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class TvModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTVShowUseCase: GetTVShowUseCase,
                                      updateTVShowUseCase: UpdateTVShowUseCase):TvViewModelProvider{
        return TvViewModelProvider(getTVShowUseCase, updateTVShowUseCase)
    }
}