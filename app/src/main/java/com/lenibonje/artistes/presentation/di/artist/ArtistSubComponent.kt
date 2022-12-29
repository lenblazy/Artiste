package com.lenibonje.artistes.presentation.di.artist

import com.lenibonje.artistes.presentation.artist.ArtistActivity
import com.lenibonje.artistes.presentation.artist.ArtistFragment
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }

}