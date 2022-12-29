package com.lenibonje.artistes.data.repository.tvshow.datasource

import com.lenibonje.artistes.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TVShowList>

}