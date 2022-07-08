package com.nitin.tmdbmoviesclient.domain.repository

import com.nitin.tmdbmoviesclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?
}