package com.nitin.tmdbmoviesclient.presentation.di.core

import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datssourceImpl.ArtistCacheDataSourceImpl
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasourceImpl.MoviesCacheDataSourceImpl
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {


    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource = MoviesCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource() : TvShowCacheDataSource = TvShowCacheDataSourceImpl()


    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDataSource = ArtistCacheDataSourceImpl()
}