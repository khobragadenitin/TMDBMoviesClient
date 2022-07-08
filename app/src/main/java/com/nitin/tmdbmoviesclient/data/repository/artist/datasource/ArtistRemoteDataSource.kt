package com.nitin.tmdbmoviesclient.data.repository.artist.datasource

import com.nitin.tmdbmoviesclient.data.model.artist.PeopleList
import com.nitin.tmdbmoviesclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getRemoteArtist() : Response<PeopleList>
}