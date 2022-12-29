package com.lenibonje.artistes.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lenibonje.artistes.data.model.tvshow.TVShow
import com.lenibonje.artistes.domain.usecases.GetTvShowsUseCase
import com.lenibonje.artistes.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows(): LiveData<List<TVShow>?> = liveData {
        val list = getTvShowsUseCase.execute()
        emit(list)
    }

    fun updateTvShows(): LiveData<List<TVShow>?> = liveData {
        val list = updateTvShowsUseCase.execute()
        emit(list)
    }

}