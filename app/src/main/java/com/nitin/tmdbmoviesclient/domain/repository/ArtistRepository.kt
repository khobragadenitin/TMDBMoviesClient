package com.nitin.tmdbmoviesclient.domain.repository

import com.nitin.tmdbmoviesclient.data.model.artist.People

interface ArtistRepository {

    suspend fun getArtists() : List<People>?

    suspend fun updateArtists() : List<People>?
}