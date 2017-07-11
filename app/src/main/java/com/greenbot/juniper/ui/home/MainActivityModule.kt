package com.greenbot.juniper.ui.home

import com.greenbot.juniper.ui.movies.MoviesFragmentComponent
import com.greenbot.juniper.ui.news.NewsFragmentComponent
import dagger.Module
import dagger.Provides

/**
 * Created by gaurav on 9/7/17.
 */
@Module(subcomponents = arrayOf(NewsFragmentComponent::class, MoviesFragmentComponent::class))
class MainActivityModule {

    @Provides
    fun getMainActivity(mainActivity: MainActivity): MainActivity {
        return mainActivity
    }

}