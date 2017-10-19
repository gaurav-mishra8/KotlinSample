package com.greenbot.juniper

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasDispatchingActivityInjector
import com.greenbot.juniper.injection.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import javax.inject.Inject
import com.greenbot.juniper.domain.data.AppDatabase
import android.arch.persistence.room.Room


/**
 * Created by gaurav on 8/7/17.
 */
class MyApplication : Application(), HasDispatchingActivityInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        DaggerAppComponent.builder().
                application(this).build()
                .inject(this)

    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

}