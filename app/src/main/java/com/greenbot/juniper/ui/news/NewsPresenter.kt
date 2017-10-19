package com.greenbot.juniper.ui.news

/**
 * Created by gaurav on 9/7/17.
 */
interface NewsPresenter {

    fun loadNews()

    fun onDetach()
    fun storeNews()
}