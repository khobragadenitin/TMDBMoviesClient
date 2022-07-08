package com.nitin.tmdbmoviesclient.domain.usecase

import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.domain.repository.TvShowRepository

class UpdateTVShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() : List<TVShow>? = tvShowRepository.updateTVShow()
}