package com.lenibonje.artistes.data.repository.tvshow.datasourceImpl

import com.lenibonje.artistes.data.db.TvShowsDao
import com.lenibonje.artistes.data.model.tvshow.TVShow
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val dao: TvShowsDao): TvShowLocalDataSource {

    override suspend fun getTvShowsFromDb(): List<TVShow> = dao.getTvShows()

    override suspend fun saveTvShowsToDB(list: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveTvShows(list)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllTvShows()
        }
    }

}