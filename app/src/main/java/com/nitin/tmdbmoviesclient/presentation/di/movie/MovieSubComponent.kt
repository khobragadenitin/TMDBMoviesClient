package com.nitin.tmdbmoviesclient.presentation.di.movie

import com.nitin.tmdbmoviesclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : MovieSubComponent

    }
}