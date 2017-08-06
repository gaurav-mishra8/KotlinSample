package com.greenbot.juniper.ui.news

import com.greenbot.juniper.domain.api.NewsApiService
import com.greenbot.juniper.domain.data.AppDatabase
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
    fun provideNewsPresenter(newsView: NewsView, newsApiService: NewsApiService, newsRepo: NewsRepository): NewsPresenter {
        return NewsPresenterImpl(newsView, newsApiService, newsRepo)
    }

    @Provides
    fun providesNewsService(@Named("NewsApi") retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    fun provideNewsRepo(appDatabase: AppDatabase): NewsRepository {
        return NewsRepository(appDatabase)
    }

}