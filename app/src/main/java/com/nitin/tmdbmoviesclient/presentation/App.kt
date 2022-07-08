package com.nitin.tmdbmoviesclient.presentation

import android.app.Application
import com.nitin.tmdbmoviesclient.BuildConfig
import com.nitin.tmdbmoviesclient.presentation.di.Injector
import com.nitin.tmdbmoviesclient.presentation.di.artiist.ArtistSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.core.*
import com.nitin.tmdbmoviesclient.presentation.di.movie.MovieSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.tvshow.TvSubComponenet

class App : Application(),Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }
    override fun getMovieSubComponent(): MovieSubComponent {
       return appComponent.movieSubComponent().create()
    }

    override fun getTvShowSubComponent(): TvSubComponenet {
        return appComponent.tvShowSubComponent().create()
    }

    override fun getArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}