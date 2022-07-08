package com.nitin.tmdbmoviesclient.data.repository.tvshow.datasourceImpl

import com.nitin.tmdbmoviesclient.data.api.TMDBService
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShowList
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(val apiTMDBService: TMDBService,val apikey : String) : TvShowRemoteDataSource {
    override suspend fun getRemoteTvShow(): Response<TVShowList> = apiTMDBService.getPopularTVShow(apikey)
}