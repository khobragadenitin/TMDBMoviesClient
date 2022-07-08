package com.nitin.tmdbmoviesclient.data.repository.artist.datasource

import com.nitin.tmdbmoviesclient.data.model.artist.People

interface ArtistCacheDataSource {

    suspend fun getArtistData() : List<People>

    suspend fun setArtistData(list : List<People>)
}