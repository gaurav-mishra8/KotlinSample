package com.greenbot.juniper.ui.news

/**
 * Created by gaurav on 9/7/17.
 */
interface NewsView {

    fun onNewsLoaded()

    fun showLoading()

    fun showError()
}