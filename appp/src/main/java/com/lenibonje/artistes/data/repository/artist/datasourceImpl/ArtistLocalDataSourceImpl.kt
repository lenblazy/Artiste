package com.lenibonje.artistes.data.repository.artist.datasourceImpl

import com.lenibonje.artistes.data.db.ArtistsDao
import com.lenibonje.artistes.data.model.artist.Artist
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val dao: ArtistsDao): ArtistLocalDataSource {

    override suspend fun getArtistsFromDb(): List<Artist> = dao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllArtists()
        }
    }

}