package com.greenbot.juniper.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.greenbot.juniper.R
import com.greenbot.juniper.utils.setupActionBar
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasDispatchingSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasDispatchingSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupActionBar("Juniper")

        Timber.plant(Timber.DebugTree())

        pager.adapter = HomePagerAdapter(supportFragmentManager)

        navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.action_news -> {
                    pager.setCurrentItem(0)
                    true
                }
                R.id.action_movies -> {
                    pager.setCurrentItem(1)
                    true
                }
                else -> {
                    throw IllegalStateException()
                }
            }
        }
    }
}
