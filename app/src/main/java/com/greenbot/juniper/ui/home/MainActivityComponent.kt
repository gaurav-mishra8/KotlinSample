package com.greenbot.juniper.ui.home

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by gaurav on 9/7/17.
 */
@Subcomponent(modules = arrayOf(MainActivityModule::class,
        MainFragmentProvider::class))
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}