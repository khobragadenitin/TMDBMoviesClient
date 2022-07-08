package com.nitin.tmdbmoviesclient.presentation.di

import com.nitin.tmdbmoviesclient.presentation.di.artiist.ArtistSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.movie.MovieSubComponent
import com.nitin.tmdbmoviesclient.presentation.di.tvshow.TvSubComponenet

interface Injector {

    fun getMovieSubComponent() : MovieSubComponent

    fun getTvShowSubComponent() : TvSubComponenet

    fun getArtistSubComponent() : ArtistSubComponent
}