package com.nitin.tmdbmoviesclient.domain.usecase

import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.domain.repository.TvShowRepository

class GetTVShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() : List<TVShow>? = tvShowRepository.getTVShow()
}