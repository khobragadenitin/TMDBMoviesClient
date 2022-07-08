package com.nitin.tmdbmoviesclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.nitin.tmdbmoviesclient.data.db.ArtistDAO
import com.nitin.tmdbmoviesclient.data.db.MovieDAO
import com.nitin.tmdbmoviesclient.data.db.TMDBDatabase
import com.nitin.tmdbmoviesclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTMDBDatabase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO = tmdbDatabase.movieDAO()

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao = tmdbDatabase.tvDAO()

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDAO = tmdbDatabase.artistDAO()


}