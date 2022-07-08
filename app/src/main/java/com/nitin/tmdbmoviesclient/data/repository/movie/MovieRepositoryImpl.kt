package com.nitin.tmdbmoviesclient.data.repository.movie

import android.util.Log
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieCacheDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.nitin.tmdbmoviesclient.data.repository.movie.datasource.MoviesLocalDataSource
import com.nitin.tmdbmoviesclient.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository{


    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        moviesLocalDataSource.deleteMovies()
        moviesLocalDataSource.saveMovieToLocalDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getRemoteMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.results
            }
        }catch (exception : Exception){
            Log.e("MYTAG", "getMoviesFromAPI: ",exception )

        }
        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = moviesLocalDataSource.getMoviesFromLocalDB()
            if (movieList.size>0){
                return movieList
            }else{
                movieList = getMoviesFromAPI()
                moviesLocalDataSource.deleteMovies()
                moviesLocalDataSource.saveMovieToLocalDB(movieList)
            }

        }catch (exception : Exception){
            Log.e("MYTAG", "getMoviesFromAPI: ",exception )

        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
            if (movieList.size>0){
                return movieList
            }else{
                movieList = getMoviesFromDB()
                movieCacheDataSource.saveMoviesToCache(movieList)
            }

        }catch (exception : Exception){
            Log.e("MYTAG", "getMoviesFromAPI: ",exception )

        }
        return movieList
    }
}