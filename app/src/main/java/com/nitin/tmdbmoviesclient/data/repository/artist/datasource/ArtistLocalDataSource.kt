package com.nitin.tmdbmoviesclient.data.repository.artist.datasource

import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromLocalDB() : List<People>

    suspend fun saveArtistToLocalDB(movies : List<People>)

    suspend fun deleteArtist()
}