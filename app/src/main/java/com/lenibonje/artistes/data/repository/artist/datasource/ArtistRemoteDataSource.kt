package com.lenibonje.artistes.data.repository.artist.datasource

import com.lenibonje.artistes.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>

}