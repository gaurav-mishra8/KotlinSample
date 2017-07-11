package com.greenbot.juniper.ui.news

import com.greenbot.juniper.domain.api.NewsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by gaurav on 8/7/17.
 */
@Module
class NewsFragmentModule {

    @Provides
    fun provideNewsView(newsFragment: NewsFragment): NewsView {
        return newsFragment
    }

    @Provides
    fun provideNewsPresenter(newsView: NewsView, newsApiService: NewsApiService): NewsPresenter {
        return NewsPresenterImpl(newsView, newsApiService)
    }

    @Provides
    fun providesNewsService(@Named("NewsApi") retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

}