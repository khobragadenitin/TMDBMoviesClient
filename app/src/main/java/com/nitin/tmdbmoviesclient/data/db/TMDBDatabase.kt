package com.nitin.tmdbmoviesclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class,People::class,TVShow::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDAO() : MovieDAO

    abstract fun tvDAO() : TvShowDao

    abstract fun artistDAO() : ArtistDAO


}