package com.greenbot.juniper.ui.news

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.greenbot.juniper.R
import com.greenbot.juniper.utils.inflate
import com.greenbot.juniper.utils.showToast
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

/**
 * Created by gaurav on 8/7/17.
 */
class NewsFragment : Fragment(), NewsView {


    @Inject
    lateinit var newsPresenter: NewsPresenter

    private val newsList by lazy {
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()
        newsPresenter.loadNews()
        context.showToast("load news called")
    }

    override fun onNewsLoaded() {
        newsList.visibility = View.VISIBLE
        progressBar.visibility = View.GONE

    }

    override fun showLoading() {
        newsList.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun showError() {
        context.showToast("error on loading")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        newsPresenter.onDetach()
    }
}