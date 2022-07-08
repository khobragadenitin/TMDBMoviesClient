package com.nitin.tmdbmoviesclient.data.repository.movie.datasourceImpl

import com.nitin.tmdbmoviesclient.data.api.TMDBService
import com.nitin.tmdbmoviesclient.data.model.movie.MovieList
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MoviesRemotedataSourceImpl(val tmdbService: TMDBService,val apikey : String) :
    MovieRemoteDataSource {

    override suspend fun getRemoteMovies(): Response<MovieList> = tmdbService.getPopularMovies(apikey)

}