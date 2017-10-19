package com.greenbot.juniper.ui.news

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by gaurav on 9/7/17.
 */

@Subcomponent(modules = arrayOf(NewsFragmentModule::class))
interface NewsFragmentComponent : AndroidInjector<NewsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NewsFragment>()
}