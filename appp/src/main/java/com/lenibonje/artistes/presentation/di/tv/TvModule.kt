package com.lenibonje.artistes.presentation.di.tv

import com.lenibonje.artistes.domain.usecases.GetTvShowsUseCase
import com.lenibonje.artistes.domain.usecases.UpdateTvShowsUseCase
import com.lenibonje.artistes.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvModule {

    @TvScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }

}