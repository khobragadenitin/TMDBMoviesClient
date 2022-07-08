package com.nitin.tmdbmoviesclient.data.repository.movie.datasource

import com.nitin.tmdbmoviesclient.data.model.movie.Movie

interface MoviesLocalDataSource {

    suspend fun getMoviesFromLocalDB() : List<Movie>

    suspend fun saveMovieToLocalDB(movies : List<Movie>)

    suspend fun deleteMovies()
}