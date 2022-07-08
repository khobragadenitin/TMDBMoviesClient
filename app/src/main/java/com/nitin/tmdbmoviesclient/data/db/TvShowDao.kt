package com.nitin.tmdbmoviesclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(movies : List<TVShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTvShow()

    @Query("SELECT * from popular_tvshow")
    suspend fun getTvShow() : List<TVShow>
}