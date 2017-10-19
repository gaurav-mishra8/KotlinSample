package com.greenbot.juniper.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by gaurav on 12/7/17.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder?, viewType: ViewType)

}