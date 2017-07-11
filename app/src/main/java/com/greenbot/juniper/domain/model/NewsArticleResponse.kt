package com.greenbot.juniper.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by gaurav on 11/7/17.
 */
data class NewsArticleResponse(@SerializedName("source") val source: String,
                               @SerializedName("status") val status: String,
                               @SerializedName("sortBy") val sortBy: String,
                               @SerializedName("articles") val articles: List<NewsArticle>) {
}