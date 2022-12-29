package com.lenibonje.artistes.data.repository.artist.datasource

import com.lenibonje.artistes.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)

}