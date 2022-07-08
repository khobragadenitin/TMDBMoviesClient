package com.nitin.tmdbmoviesclient.presentation.di.core

import com.nitin.tmdbmoviesclient.data.db.ArtistDAO
import com.nitin.tmdbmoviesclient.data.db.MovieDAO
import com.nitin.tmdbmoviesclient.data.db.TvShowDao
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datssourceImpl.ArtistLocalDataSourceImpl
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MoviesLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasourceImpl.MoviesLocalDataSourceImpl
import com.nitin.tmdbmoviesclient.data.repository.movie.datasourceImpl.MoviesRemotedataSourceImpl
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO) : MoviesLocalDataSource{
        return MoviesLocalDataSourceImpl(movieDAO)
    }


    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao) : TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }


    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO) : ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDAO)
    }
}