package com.greenbot.juniper.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.greenbot.juniper.ui.ViewType

/**
 * Created by gaurav on 11/7/17.
 */
data class NewsArticle(@SerializedName("author") val author: String,
                       @SerializedName("title") val title: String,
                       @SerializedName("description") val desc: String,
                       @SerializedName("url") val url: String,
                       @SerializedName("urlToImage") val imageUrl: String,
                       @SerializedName("publishedAt") val publishedAt: String) : ViewType, Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun getViewType(): Int = ViewType.LIST_ITEM

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeString(desc)
        parcel.writeString(url)
        parcel.writeString(imageUrl)
        parcel.writeString(publishedAt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsArticle> {
        override fun createFromParcel(parcel: Parcel): NewsArticle = NewsArticle(parcel)
        override fun newArray(size: Int): Array<NewsArticle?> = arrayOfNulls(size)
    }


}