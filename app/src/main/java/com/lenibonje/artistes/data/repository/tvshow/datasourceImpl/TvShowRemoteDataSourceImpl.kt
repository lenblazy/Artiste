package com.lenibonje.artistes.data.repository.tvshow.datasourceImpl

import com.lenibonje.artistes.data.api.TMDBService
import com.lenibonje.artistes.data.model.tvshow.TVShowList
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TVShowList> = tmdbService.getPopularTVShows(apiKey)

}