package com.nitin.tmdbmoviesclient.data.repository.tvshow.datasourceImpl

import com.nitin.tmdbmoviesclient.data.db.TvShowDao
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowFromLocalDB(): List<TVShow>  = tvShowDao.getTvShow()

    override suspend fun saveTvShowToLocalDB(movies: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(movies)
        }
    }

    override suspend fun deleteTvShow() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }
}