package com.greenbot.juniper.ui.news

import com.greenbot.juniper.domain.api.NewsApiService
import com.greenbot.juniper.domain.data.news.NewsEntity
import com.greenbot.juniper.domain.model.NewsArticleResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by gaurav on 9/7/17.
 */
class NewsPresenterImpl @Inject constructor(newsView: NewsView, newsApiService: NewsApiService, val newsRepo: NewsRepository) : NewsPresenter {

    private var newsView: NewsView
    private var newsApiService: NewsApiService

    private val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    init {
        this.newsView = newsView
        this.newsApiService = newsApiService
    }

    override fun loadNews() {

        compositeDisposable?.add(newsApiService.getNewsList("techCrunch")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { it: Disposable -> newsView.showLoading() }
                .doOnSuccess { it: NewsArticleResponse -> newsView.onNewsLoaded(it.articles) }
                .doOnError(Consumer { it: Throwable -> newsView.showError() })
                .timeout(5000, TimeUnit.MILLISECONDS)
                .subscribe())

    }

    override fun storeNews() {

        Observable.fromCallable {
            newsRepo.storeNews(NewsEntity().apply {
                this.author = "gaurav"
                this.title = "dummy news"
            })
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { Timber.d("insertion completed") }
    }

    override fun onDetach() {
        compositeDisposable?.clear()
    }

}