package com.nitin.tmdbmoviesclient.domain.repository

import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow

interface TvShowRepository {

    suspend fun getTVShow() : List<TVShow>?

    suspend fun updateTVShow() : List<TVShow>?
}