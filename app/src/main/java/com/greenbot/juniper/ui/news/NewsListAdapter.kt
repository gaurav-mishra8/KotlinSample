package com.greenbot.juniper.ui.news

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.greenbot.juniper.domain.model.NewsArticle
import com.greenbot.juniper.domain.model.NewsArticleResponse
import com.greenbot.juniper.ui.ViewType
import com.greenbot.juniper.ui.ViewTypeDelegateAdapter
import java.util.ArrayList

/**
 * Created by gaurav on 12/7/17.
 */
class NewsListAdapter(listener: NewsDelegateAdapter.onViewSelectedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = ViewType.LOADING
    }

    init {
        delegateAdapters.put(ViewType.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(ViewType.LIST_ITEM, NewsDelegateAdapter(listener))
        items = ArrayList()
        items.add(loadingItem)
    }


    fun addItem(data: List<NewsArticle>) {
        items.removeAt(0)
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }


    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }

}