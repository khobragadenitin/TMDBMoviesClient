package com.nitin.tmdbmoviesclient.data.repository.movie.datasource

import com.nitin.tmdbmoviesclient.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache() : List<Movie>

    suspend fun saveMoviesToCache(movie: List<Movie>)


}