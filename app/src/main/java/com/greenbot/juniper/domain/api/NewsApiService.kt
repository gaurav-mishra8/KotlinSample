package com.greenbot.juniper.domain.api

import com.greenbot.juniper.domain.model.NewsArticleResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by gaurav on 11/7/17.
 */
interface NewsApiService {

    @GET("/v1/articles")
    fun getNewsList(@Query("source") source: String,
                    @Query("sortBy") sortBy: String = "latest",
                    @Query("apiKey") api: String = "78be71b8f91343c6956d1fd91d7dcc29"): Single<NewsArticleResponse>


}