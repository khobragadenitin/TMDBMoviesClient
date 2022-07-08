package com.nitin.tmdbmoviesclient.presentation.di.tvshow

import com.nitin.tmdbmoviesclient.presentation.tv.TvActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvModule::class])
interface TvSubComponenet {
    fun inject(tvActivity: TvActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : TvSubComponenet
    }
}