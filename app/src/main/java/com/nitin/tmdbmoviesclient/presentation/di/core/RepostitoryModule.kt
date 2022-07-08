package com.nitin.tmdbmoviesclient.presentation.di.core

import com.nitin.tmdbmoviesclient.data.repository.artist.ArtistRepositoryImpl
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.MovieRepositoryImpl
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MoviesLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.nitin.tmdbmoviesclient.domain.repository.ArtistRepository
import com.nitin.tmdbmoviesclient.domain.repository.MovieRepository
import com.nitin.tmdbmoviesclient.domain.repository.TvShowRepository
import com.nitin.tmdbtvShowsclient.data.repository.tvshow.TvShowRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepostitoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDataSource: MovieRemoteDataSource,
    moviesLocalDataSource: MoviesLocalDataSource,
    movieCacheDataSource: MovieCacheDataSource) : MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource, moviesLocalDataSource, movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(tvshowRemoteDataSource: TvShowRemoteDataSource,
                               tvshowLocalDataSource: TvShowLocalDataSource,
                               tvshowCacheDataSource: TvShowCacheDataSource) : TvShowRepository{
        return TvShowRepositoryImpl(tvshowRemoteDataSource,tvshowLocalDataSource,tvshowCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideArtistRepository(artistRemoteDataSource: ArtistRemoteDataSource,
                               artistLocalDataSource: ArtistLocalDataSource,
                               artistCacheDataSource: ArtistCacheDataSource) : ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistCacheDataSource, artistLocalDataSource
        )
    }


}