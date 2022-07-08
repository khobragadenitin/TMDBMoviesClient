package com.nitin.tmdbmoviesclient.data.repository.artist.datssourceImpl

import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource{
    private var peopleList : ArrayList<People> = ArrayList()
    override suspend fun getArtistData(): List<People> {
        return peopleList
    }

    override suspend fun setArtistData(list: List<People>) {
        peopleList.clear()
        peopleList = ArrayList(list)
    }
}