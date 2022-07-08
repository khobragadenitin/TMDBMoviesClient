package com.nitin.tmdbmoviesclient.data.db

import androidx.lifecycle.ViewModelStore
import androidx.room.*
import com.nitin.tmdbmoviesclient.data.model.movie.Movie

@Dao
interface MovieDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * from popular_movies")
    suspend fun getMovies() : List<Movie>
}