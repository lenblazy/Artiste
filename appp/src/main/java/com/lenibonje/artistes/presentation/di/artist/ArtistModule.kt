package com.lenibonje.artistes.presentation.di.artist

import com.lenibonje.artistes.domain.usecases.GetArtistsUseCase
import com.lenibonje.artistes.domain.usecases.UpdateArtistsUseCase
import com.lenibonje.artistes.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}