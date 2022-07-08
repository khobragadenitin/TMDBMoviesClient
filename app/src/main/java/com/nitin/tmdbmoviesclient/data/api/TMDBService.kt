package com.nitin.tmdbmoviesclient.data.api

import com.nitin.tmdbmoviesclient.data.model.movie.MovieList
import com.nitin.tmdbmoviesclient.data.model.artist.PeopleList
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apikey : String,) : Response<MovieList>


    @GET("tv/popular")
    suspend fun getPopularTVShow(@Query("api_key") apikey : String,) : Response<TVShowList>


    @GET("person/popular")
    suspend fun getPopularPerson(@Query("api_key") apikey : String,) : Response<PeopleList>
}