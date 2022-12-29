package com.lenibonje.artistes.data.repository.tvshow

import android.util.Log
import com.lenibonje.artistes.data.model.tvshow.TVShow
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.lenibonje.artistes.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.lenibonje.artistes.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val cacheDataSource: TvShowCacheDataSource,
    private val localDataSource: TvShowLocalDataSource,
    private val remoteDataSource: TvShowRemoteDataSource
) : TvShowsRepository {

    private suspend fun getTvShowsFromApi(): List<TVShow> {
        lateinit var list: List<TVShow>

        try {
            val response = remoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                list = body.TVShows
            }

        } catch (e: Exception) {
            Log.d("MyTag", e.message.toString())
        }

        return list
    }

    private suspend fun getTvShowsFromDb(): List<TVShow> {
        lateinit var list: List<TVShow>

        try {
            list = localDataSource.getTvShowsFromDb()
        } catch (e: Exception) {
            Log.d("MyTag", e.message.toString())
        }

        if (list.isNotEmpty()) {
            return list
        } else {
            list = getTvShowsFromApi()
            localDataSource.saveTvShowsToDB(list)
        }

        return list
    }

    private suspend fun getTvShowsFromCache(): List<TVShow> {
        lateinit var list: List<TVShow>

        try {
            list = cacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.d("MyTag", e.message.toString())
        }

        if (list.isNotEmpty()) {
            return list
        } else {
            list = getTvShowsFromDb()
            cacheDataSource.saveTvShowsToCache(list)
        }

        return list
    }

    override suspend fun getTvShows(): List<TVShow> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TVShow> {
        val newList = getTvShowsFromApi()
        localDataSource.clearAll()
        localDataSource.saveTvShowsToDB(newList)
        cacheDataSource.saveTvShowsToCache(newList)
        return newList
    }

}