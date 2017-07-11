package com.greenbot.juniper.ui.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.greenbot.juniper.ui.movies.MoviesFragment
import com.greenbot.juniper.ui.news.NewsFragment

/**
 * Created by gaurav on 8/7/17.
 */

class HomePagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> NewsFragment()
        1 -> MoviesFragment()
        else -> {
            throw IllegalStateException()
        }
    }


    override fun getCount(): Int = 2

}