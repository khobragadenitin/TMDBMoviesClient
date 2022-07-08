package com.nitin.tmdbmoviesclient.data.repository.movie.datasourceImpl

import com.nitin.tmdbmoviesclient.data.db.MovieDAO
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MoviesLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesLocalDataSourceImpl(private val movieDAO: MovieDAO) : MoviesLocalDataSource {

    override suspend fun getMoviesFromLocalDB(): List<Movie> = movieDAO.getMovies()

    override suspend fun saveMovieToLocalDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun deleteMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }

    }
}