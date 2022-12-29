package com.lenibonje.artistes.data.repository.artist

import android.util.Log
import com.lenibonje.artistes.data.model.artist.Artist
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistCacheDataSource
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistLocalDataSource
import com.lenibonje.artistes.data.repository.artist.datasource.ArtistRemoteDataSource
import com.lenibonje.artistes.domain.repository.ArtistsRepository

class ArtistsRepositoryImpl(
    private val cacheDataSource: ArtistCacheDataSource,
    private val localDataSource: ArtistLocalDataSource,
    private val remoteDataSource: ArtistRemoteDataSource
) : ArtistsRepository {

    private suspend fun getArtistsFromApi(): List<Artist>{
        lateinit var list: List<Artist>

        try {
            val response = remoteDataSource.getArtists()
            val body = response.body()
            if (body != null){
                list = body.artists
            }

        }catch (e: Exception){
            list = listOf()
            Log.d("MyTag", e.message.toString())
        }

        return list
    }

    private suspend fun getArtistsFromDb(): List<Artist>{
        lateinit var list: List<Artist>

        try {
            list = localDataSource.getArtistsFromDb()
        }catch (e: Exception){
            Log.d("MyTag", e.message.toString())
        }

        if (list.isNotEmpty()){
            return list
        }else{
            list = getArtistsFromApi()
            localDataSource.saveArtistsToDB(list)
        }

        return list
    }

    private suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var list: List<Artist>

        try {
            list = cacheDataSource.getArtistsFromCache()
        }catch (e: Exception){
            Log.d("MyTag", e.message.toString())
        }

        if (list.isNotEmpty()){
            return list
        }else{
            list = getArtistsFromDb()
            cacheDataSource.saveArtistsToCache(list)
        }

        return list
    }

    override suspend fun getArtists(): List<Artist> = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist> {
        val newList = getArtistsFromApi()
        localDataSource.clearAll()
        localDataSource.saveArtistsToDB(newList)
        cacheDataSource.saveArtistsToCache(newList)
        return newList
    }

}