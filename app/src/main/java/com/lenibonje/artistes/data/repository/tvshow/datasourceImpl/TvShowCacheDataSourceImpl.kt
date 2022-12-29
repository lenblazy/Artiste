package com.lenibonje.artistes.data.repository.tvshow.datasourceImpl

import com.lenibonje.artistes.data.model.tvshow.TVShow
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTvShowsFromCache(): List<TVShow> = tvShowList

    override suspend fun saveTvShowsToCache(tVShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tVShows)
    }

}