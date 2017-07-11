package com.greenbot.juniper.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by gaurav on 11/7/17.
 */
data class NewsArticle(@SerializedName("author") val author: String,
                       @SerializedName("title") val title: String,
                       @SerializedName("description") val desc: String,
                       @SerializedName("url") val url: String,
                       @SerializedName("urlToImage") val imageUrl: String,
                       @SerializedName("publishedAt") val publishedAt: String) {
}