package com.nitin.tmdbmoviesclient.presentation.di.artiist

import com.nitin.tmdbmoviesclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class], )
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : ArtistSubComponent
    }
}