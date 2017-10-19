package com.greenbot.juniper.ui.news

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.greenbot.juniper.R
import com.greenbot.juniper.domain.model.NewsArticle
import com.greenbot.juniper.ui.ViewType
import com.greenbot.juniper.ui.ViewTypeDelegateAdapter
import com.greenbot.juniper.utils.inflate
import com.greenbot.juniper.utils.loadUrl
import kotlinx.android.synthetic.main.item_news_list.view.*

/**
 * Created by gaurav on 12/7/17.
 */
class NewsDelegateAdapter(val listener: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onClicked(pos: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {

        val view = parent?.inflate(R.layout.item_news_list)
        val newsHolder = NewsViewHolder(view)
        view?.setOnClickListener {
            listener.onClicked(newsHolder.adapterPosition)
        }
        return newsHolder

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, viewType: ViewType) {
        holder as NewsViewHolder
        holder.bind(viewType as NewsArticle)
    }

    inner class NewsViewHolder(val view: View?) : RecyclerView.ViewHolder(view) {

        fun bind(item: NewsArticle) {

            with(itemView) {
                tv_title.text = item.title
                tv_author.text = item.author
                img_news.loadUrl(item.imageUrl)
                tv_published_at.text = item.publishedAt
            }

        }

    }


}