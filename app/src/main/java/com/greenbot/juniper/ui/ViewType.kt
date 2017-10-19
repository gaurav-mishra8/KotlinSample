package com.greenbot.juniper.ui

/**
 * Created by gaurav on 12/7/17.
 */
interface ViewType {

    companion object {
        const final val LOADING = 0
        const final val LIST_ITEM = 1
    }

    fun getViewType(): Int
}