package com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getRemoteTvShow() : Response<TVShowList>
}