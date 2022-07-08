package com.nitin.tmdbmoviesclient.presentation.di.core

import com.nitin.tmdbmoviesclient.presentation.di.artiist.ArtistSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.movie.MovieSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.tvshow.TvSubComponenet
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepostitoryModule::class,
    UseCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory

    fun tvShowSubComponent() : TvSubComponenet.Factory

    fun artistSubComponent() : ArtistSubComponent.Factory

}