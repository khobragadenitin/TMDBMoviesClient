package com.nitin.tmdbmoviesclient.data.repository.artist.datssourceImpl

import com.nitin.tmdbmoviesclient.data.db.ArtistDAO
import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(val artistDAO: ArtistDAO) : ArtistLocalDataSource{

    override suspend fun getArtistFromLocalDB(): List<People>  = artistDAO.getArtists()


    override suspend fun saveArtistToLocalDB(movies: List<People>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveTvShow(movies)
        }
    }

    override suspend fun deleteArtist() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtist()
        }
    }
}