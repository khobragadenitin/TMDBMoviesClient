package com.nitin.tmdbmoviesclient.data.repository.artist.datssourceImpl

import com.nitin.tmdbmoviesclient.data.api.TMDBService
import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.artist.PeopleList
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(val tmdbService: TMDBService, val apikey : String) : ArtistRemoteDataSource{
    override suspend fun getRemoteArtist(): Response<PeopleList>  = tmdbService.getPopularPerson(apikey)
}