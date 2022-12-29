package com.lenibonje.artistes.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lenibonje.artistes.data.model.artist.Artist
import com.lenibonje.artistes.domain.usecases.GetArtistsUseCase
import com.lenibonje.artistes.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtist(): LiveData<List<Artist>?> = liveData {
        val list = getArtistsUseCase.execute()
        emit(list)
    }

    fun updateArtist(): LiveData<List<Artist>?> = liveData {
        val list = updateArtistsUseCase.execute()
        emit(list)
    }

}