package com.greenbot.juniper.ui.movies

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by gaurav on 11/7/17.
 */
@Subcomponent(modules = arrayOf(MoviesFragmentModule::class))
interface MoviesFragmentComponent : AndroidInjector<MoviesFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesFragment>()

}