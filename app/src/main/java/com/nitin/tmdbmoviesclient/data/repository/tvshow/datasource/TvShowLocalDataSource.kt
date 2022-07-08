package com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource

import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow

interface TvShowLocalDataSource {

    suspend fun getTvShowFromLocalDB() : List<TVShow>

    suspend fun saveTvShowToLocalDB(movies : List<TVShow>)

    suspend fun deleteTvShow()
}