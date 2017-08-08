package com.greenbot.juniper

import com.greenbot.juniper.domain.api.NewsApiService
import com.greenbot.juniper.domain.data.AppDatabase
import com.greenbot.juniper.domain.model.NewsArticleResponse
import com.greenbot.juniper.ui.news.NewsPresenterImpl
import com.greenbot.juniper.ui.news.NewsRepository
import com.greenbot.juniper.ui.news.NewsView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import org.mockito.internal.verification.Times

/**
 * Created by gaurav on 8/8/17.
 */
class NewsPresenterTest {

    lateinit var testSub: TestSubscriber<NewsArticleResponse>
    lateinit var newsApiService: NewsApiService
    lateinit var newsView: NewsView
    lateinit var newsRepo: NewsRepository
    lateinit var appDatabase: AppDatabase

    @Before
    fun setup() {
        testSub = TestSubscriber<NewsArticleResponse>()
        newsApiService = mock<NewsApiService>()
        newsView = mock<NewsView>()
        appDatabase = mock<AppDatabase>()
        newsRepo = NewsRepository(appDatabase)
    }

    @Test
    fun test_newsapi_success() {
        val newsArticleResponse = NewsArticleResponse("techCrunch", "success", "date", listOfNotNull())
        val response = Single.just(newsArticleResponse)

        whenever(newsApiService.getNewsList(any(), any(), any())).thenReturn(response)

        // call
        val newsPresenter = NewsPresenterImpl(newsView, newsApiService, newsRepo, Schedulers.trampoline(), Schedulers.trampoline())
        newsPresenter.loadNews()

        verify(newsView, mode = Times(1)).showLoading()

    }


}