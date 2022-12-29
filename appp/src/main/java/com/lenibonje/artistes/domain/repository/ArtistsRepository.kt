package com.lenibonje.artistes.domain.repository

import com.lenibonje.artistes.data.model.artist.Artist


interface ArtistsRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?

}