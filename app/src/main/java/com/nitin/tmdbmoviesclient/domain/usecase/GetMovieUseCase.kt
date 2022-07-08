package com.nitin.tmdbmoviesclient.domain.usecase

import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.getMovies()
}