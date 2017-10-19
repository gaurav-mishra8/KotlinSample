package com.greenbot.juniper.injection

import android.app.Activity
import com.greenbot.juniper.ui.home.MainActivity
import com.greenbot.juniper.ui.home.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by gaurav on 8/7/17.
 */
@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}