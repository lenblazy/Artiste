package com.lenibonje.artistes.presentation.di.movie

import com.lenibonje.artistes.presentation.movie.MovieActivity
import com.lenibonje.artistes.presentation.movie.MovieFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }

}