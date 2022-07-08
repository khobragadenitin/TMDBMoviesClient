package com.nitin.tmdbmoviesclient.data.repository.artist

import android.util.Log
import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.nitin.tmdbmoviesclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(private val artistRemoteDataSource: ArtistRemoteDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource,
                           private val artistLocalDataSource: ArtistLocalDataSource) : ArtistRepository {


    override suspend fun getArtists(): List<People>?  = getArtistFromCache()

    override suspend fun updateArtists(): List<People>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSource.deleteArtist()
        artistLocalDataSource.saveArtistToLocalDB(newListOfArtist)
        artistCacheDataSource.setArtistData(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromAPI():List<People> {
        lateinit var artistList: List<People>
        try {
            val response = artistRemoteDataSource.getRemoteArtist()
            val body = response.body()
            if (body!=null){
                artistList = body.results
            }
        }catch (exception : Exception){
            Log.e("MYTAG", "getMoviesFromAPI: ",exception )

        }
        return artistList
    }

    suspend fun getArtistFromDB() : List<People>{
        lateinit var artistList: List<People>
        try {
            val list = artistLocalDataSource.getArtistFromLocalDB()
            if (list.size>0){
                return list
            }else{
                artistList = getArtistFromAPI()
                artistLocalDataSource.saveArtistToLocalDB(artistList)
            }
        }catch (exception : Exception){
            Log.e("MYTAG", "getMoviesFromAPI: ",exception )

        }
        return artistList
    }

    suspend fun getArtistFromCache() : List<People>{
        lateinit var artistList: List<People>
        try {
            artistList = artistCacheDataSource.getArtistData()
            if (artistList.size>0){
                return artistList
            }else{
                artistList = getArtistFromDB()
                artistCacheDataSource.setArtistData(artistList)
            }

        }catch (exception : Exception){
            Log.e("MYTAG", "getMoviesFromAPI: ",exception )

        }
        return artistList
    }
}