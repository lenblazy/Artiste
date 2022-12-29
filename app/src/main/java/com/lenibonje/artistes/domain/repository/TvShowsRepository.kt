package com.lenibonje.artistes.domain.repository

import com.lenibonje.artistes.data.model.tvshow.TVShow

interface TvShowsRepository {

    suspend fun getTvShows(): List<TVShow>?
    suspend fun updateTvShows(): List<TVShow>?

}