package com.greenbot.juniper.ui.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.greenbot.juniper.R
import com.greenbot.juniper.ui.ViewType
import com.greenbot.juniper.ui.ViewTypeDelegateAdapter
import com.greenbot.juniper.utils.inflate

/**
 * Created by gaurav on 12/7/17.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder = LoadingViewHolder(parent!!)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, viewType: ViewType) {

    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}