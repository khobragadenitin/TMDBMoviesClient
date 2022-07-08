package com.nitin.tmdbtvShowsclient.data.repository.tvshow

import android.util.Log
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.nitin.tmdbmoviesclient.domain.repository.TvShowRepository

import java.lang.Exception

class TvShowRepositoryImpl(private val tvShowRemoteDataSource: TvShowRemoteDataSource,
                           private val tvShowLocalDataSource: TvShowLocalDataSource,
                           private val tvShowCacheDataSource: TvShowCacheDataSource) :
    TvShowRepository {
    
    
    override suspend fun getTVShow(): List<TVShow>? = getTvShowFromCache()

    override suspend fun updateTVShow(): List<TVShow>? {
        val newListOfMovies = getTvShowFromAPI()
        tvShowLocalDataSource.deleteTvShow()
        tvShowLocalDataSource.saveTvShowToLocalDB(newListOfMovies)
        tvShowCacheDataSource.setTvShowData(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getTvShowFromAPI():List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getRemoteTvShow()
            val body = response.body()
            if (body!=null){
                tvShowList = body.results
            }
        }catch (exception : Exception){
            Log.e("MYTAG", "getTvShowFromAPI: ",exception )

        }
        return tvShowList
    }

    suspend fun getTvShowFromDB() : List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromLocalDB()
            if (tvShowList.size>0){
                return tvShowList
            }else{
                tvShowList = getTvShowFromAPI()
                tvShowLocalDataSource.deleteTvShow()
                tvShowLocalDataSource.saveTvShowToLocalDB(tvShowList)
            }

        }catch (exception : Exception){
            Log.e("MYTAG", "getTvShowFromAPI: ",exception )

        }
        return tvShowList
    }

    suspend fun getTvShowFromCache() : List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowData()
            if (tvShowList.size>0){
                return tvShowList
            }else{
                tvShowList = getTvShowFromDB()
                tvShowCacheDataSource.setTvShowData(tvShowList)
            }

        }catch (exception : Exception){
            Log.e("MYTAG", "getTvShowFromAPI: ",exception )

        }
        return tvShowList
    }
}