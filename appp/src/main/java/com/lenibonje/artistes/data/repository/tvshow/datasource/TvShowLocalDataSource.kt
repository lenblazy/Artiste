package com.lenibonje.artistes.data.repository.tvshow.datasource

import com.lenibonje.artistes.data.model.tvshow.TVShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDb(): List<TVShow>

    suspend fun saveTvShowsToDB(list: List<TVShow>)

    suspend fun clearAll()

}