package com.nitin.tmdbmoviesclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow

@Dao
interface ArtistDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(movies : List<People>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtist()

    @Query("SELECT * from popular_artists")
    suspend fun getArtists() : List<People>
}