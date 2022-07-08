package com.nitin.tmdbmoviesclient.data.repository.movie.datasource

import com.nitin.tmdbmoviesclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getRemoteMovies() : Response<MovieList>
}