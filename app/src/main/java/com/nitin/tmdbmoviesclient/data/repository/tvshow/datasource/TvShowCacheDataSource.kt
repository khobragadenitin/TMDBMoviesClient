package com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource

import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow

interface TvShowCacheDataSource {

    suspend fun getTvShowData() : List<TVShow>

    suspend fun setTvShowData(list : List<TVShow>)
}