package com.greenbot.juniper.ui.movies

import javax.inject.Inject

/**
 * Created by gaurav on 11/7/17.
 */
class MoviesPresenterImpl @Inject constructor(moviesView: MoviesView) : MoviesPresenter {

    private val moviesView: MoviesView

    init {
        this.moviesView = moviesView
    }

    override fun loadMovies() {

    }


}