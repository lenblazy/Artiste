package com.lenibonje.artistes.data.repository.artist.datasource

import com.lenibonje.artistes.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDb(): List<Artist>

    suspend fun saveArtistsToDB(artists:List<Artist>)

    suspend fun clearAll()

}