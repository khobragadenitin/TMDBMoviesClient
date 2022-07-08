package com.nitin.tmdbmoviesclient.presentation.di.core

import com.nitin.tmdbmoviesclient.data.api.TMDBService
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datssourceImpl.ArtistRemoteDataSourceImpl
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasourceImpl.MoviesRemotedataSourceImpl
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(private val apikey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource{
        return MoviesRemotedataSourceImpl(
            tmdbService, apikey
        )
    }


    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apikey
        )
    }


    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(
            tmdbService, apikey
        )
    }

}