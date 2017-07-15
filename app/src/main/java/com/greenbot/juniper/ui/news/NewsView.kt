package com.greenbot.juniper.ui.news

import com.greenbot.juniper.domain.model.NewsArticle

/**
 * Created by gaurav on 9/7/17.
 */
interface NewsView {

    fun onNewsLoaded(articles: List<NewsArticle>)

    fun showLoading()

    fun showError()
}