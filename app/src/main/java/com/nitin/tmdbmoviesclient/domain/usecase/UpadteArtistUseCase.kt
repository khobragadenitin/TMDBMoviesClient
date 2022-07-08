package com.nitin.tmdbmoviesclient.domain.usecase

import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.domain.repository.ArtistRepository

class UpadteArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute() : List<People>? = artistRepository.updateArtists()
}