package com.greenbot.juniper.ui.news

import com.greenbot.juniper.domain.api.NewsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by gaurav on 9/7/17.
 */
class NewsPresenterImpl @Inject constructor(newsView: NewsView, newsApiService: NewsApiService) : NewsPresenter {

    private var newsView: NewsView
    private var newsApiService: NewsApiService

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        this.newsView = newsView
        this.newsApiService = newsApiService
    }

    override fun loadNews() {

        compositeDisposable.add(newsApiService.getNewsList("techCrunch")
                .doOnSubscribe { newsView.showLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext { newsView.onNewsLoaded() }
                .doOnError(Consumer { newsView.showError() })
                .subscribe { Timber.d("result received", it.articles) })


    }

    override fun onDetach() {
        compositeDisposable.clear()
    }

}