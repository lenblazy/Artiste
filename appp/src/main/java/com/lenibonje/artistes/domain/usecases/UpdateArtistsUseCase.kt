package com.lenibonje.artistes.domain.usecases

import com.lenibonje.artistes.data.model.artist.Artist
import com.lenibonje.artistes.domain.repository.ArtistsRepository

class UpdateArtistsUseCase(private val artistsRepository: ArtistsRepository) {

    suspend fun execute(): List<Artist>? = artistsRepository.updateArtists()

}