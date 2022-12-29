package com.lenibonje.artistes.domain.usecases

import com.lenibonje.artistes.data.model.tvshow.TVShow
import com.lenibonje.artistes.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute(): List<TVShow>? = tvShowsRepository.getTvShows()

}