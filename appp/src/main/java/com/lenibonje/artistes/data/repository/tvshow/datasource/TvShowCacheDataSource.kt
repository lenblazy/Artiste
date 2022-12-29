package com.lenibonje.artistes.data.repository.tvshow.datasource

import com.lenibonje.artistes.data.model.tvshow.TVShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TVShow>

    suspend fun saveTvShowsToCache(tVShows: List<TVShow>)

}