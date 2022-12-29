package com.lenibonje.artistes.data.repository.artist.datasourceImpl

import com.lenibonje.artistes.data.api.TMDBService
import com.lenibonje.artistes.data.model.artist.ArtistList
import com.lenibonje.artistes.data.model.movie.MovieList
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistRemoteDataSource
import com.lenibonje.artistes.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}