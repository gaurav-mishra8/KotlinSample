package com.greenbot.juniper.ui.movies

import dagger.Module
import dagger.Provides

/**
 * Created by gaurav on 11/7/17.
 */
@Module
abstract class MoviesFragmentModule {

    @Provides
    fun providesMoviesView(moviesFragment: MoviesFragment): MoviesView {
        return moviesFragment
    }

    @Provides
    fun providesMoviesPresenter(moviesView: MoviesView): MoviesPresenter {
        return MoviesPresenterImpl(moviesView)
    }


}


