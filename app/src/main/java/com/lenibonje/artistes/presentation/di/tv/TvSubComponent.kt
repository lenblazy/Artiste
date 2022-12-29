package com.lenibonje.artistes.presentation.di.tv

import com.lenibonje.artistes.presentation.tv.TvActivity
import com.lenibonje.artistes.presentation.tv.TvFragment
import dagger.Subcomponent

@TvScope
@Subcomponent(modules = [TvModule::class])
interface TvSubComponent {

    fun inject(tvActivity: TvActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvSubComponent
    }

}