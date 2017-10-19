package com.greenbot.juniper.injection

import com.greenbot.juniper.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by gaurav on 8/7/17.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance fun application(app: MyApplication): Builder
        fun build(): AppComponent

    }

    fun inject(app: MyApplication)

}