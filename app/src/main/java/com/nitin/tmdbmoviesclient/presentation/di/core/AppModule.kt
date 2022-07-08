package com.nitin.tmdbmoviesclient.presentation.di.core

import android.content.Context
import com.nitin.tmdbmoviesclient.presentation.di.artiist.ArtistSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.movie.MovieSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.tvshow.TvSubComponenet
import dagger.Module
import dagger.Provides


@Module(subcomponents = [MovieSubComponent::class,
TvSubComponenet::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Provides
    fun provideApplicationContext() : Context = context.applicationContext
}