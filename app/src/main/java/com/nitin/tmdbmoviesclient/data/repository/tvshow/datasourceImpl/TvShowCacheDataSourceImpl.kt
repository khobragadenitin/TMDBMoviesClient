package com.nitin.tmdbmoviesclient.data.repository.tvshow.datasourceImpl

import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList : ArrayList<TVShow> = ArrayList()
    override suspend fun getTvShowData(): List<TVShow> = tvShowList

    override suspend fun setTvShowData(list: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(list)
    }
}