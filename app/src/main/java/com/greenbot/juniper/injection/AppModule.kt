package com.greenbot.juniper.injection

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.greenbot.juniper.MyApplication
import com.greenbot.juniper.ui.home.MainActivityComponent
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by gaurav on 8/7/17.
 */
@Module(subcomponents = arrayOf(MainActivityComponent::class))
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: MyApplication): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideSharedPreference(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    @Named("NewsApi")
    fun provideNewsRetrofit(client: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl("https://newsapi.org/")
                .build()

    }

    @Provides
    @Singleton
    @Named("MoviesApi")
    fun provideMoviesRetrofit(client: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl("https://newsapi.org/")
                .build()

    }

    @Provides
    @Singleton
    fun provideOkHttpInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
    }

}