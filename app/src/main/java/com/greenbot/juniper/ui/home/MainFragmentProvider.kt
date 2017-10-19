package com.greenbot.juniper.ui.home

import android.support.v4.app.Fragment
import com.greenbot.juniper.ui.movies.MoviesFragment
import com.greenbot.juniper.ui.movies.MoviesFragmentComponent
import com.greenbot.juniper.ui.news.NewsFragment
import com.greenbot.juniper.ui.news.NewsFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

/**
 * Created by gaurav on 9/7/17.
 */
@Module
abstract class MainFragmentProvider {

    @Binds
    @IntoMap
    @FragmentKey(NewsFragment::class)
    internal abstract fun provideNewsFragmentFactory(builder: NewsFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(MoviesFragment::class)
    internal abstract fun provideMoviesFragment(builder: MoviesFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>


}
