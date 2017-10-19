package com.greenbot.juniper.ui.news

import com.greenbot.juniper.domain.data.AppDatabase
import com.greenbot.juniper.domain.data.news.NewsEntity
import javax.inject.Inject

/**
 * Created by gaurav on 20/7/17.
 */
class NewsRepository @Inject constructor(val appDatabse: AppDatabase) {

    fun getNews(): List<NewsEntity> {
        return appDatabse.newsDAO().news
    }

    fun storeNews(newsList: List<NewsEntity>) {
        appDatabse.newsDAO().insertAll(newsList)
    }

    fun storeNews(newsEntity: NewsEntity) {
        appDatabse.newsDAO().insert(newsEntity)
    }

}