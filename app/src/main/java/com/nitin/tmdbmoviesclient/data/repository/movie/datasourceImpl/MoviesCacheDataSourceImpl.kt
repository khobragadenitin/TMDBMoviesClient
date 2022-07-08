package com.nitin.tmdbmoviesclient.data.repository.movie.datasourceImpl

import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieCacheDataSource

class MoviesCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList : ArrayList<Movie> = ArrayList()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }
}