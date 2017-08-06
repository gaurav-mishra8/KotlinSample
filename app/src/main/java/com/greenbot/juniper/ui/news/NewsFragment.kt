package com.greenbot.juniper.ui.news

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.greenbot.juniper.R
import com.greenbot.juniper.domain.model.NewsArticle
import com.greenbot.juniper.utils.inflate
import com.greenbot.juniper.utils.showToast
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_news.*
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by gaurav on 8/7/17.
 */
class NewsFragment : Fragment(), NewsView, NewsDelegateAdapter.onViewSelectedListener {

    @Inject
    lateinit var newsPresenter: NewsPresenter

    private val newsList by lazy {
        news_list.setHasFixedSize(true)
        news_list.adapter = NewsListAdapter(this)
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
        Timber.d("load news called ")
        newsPresenter.storeNews()
    }

    override fun onNewsLoaded(articles: List<NewsArticle>) {
        progressBar.visibility = View.GONE
        newsList.visibility = View.VISIBLE
        (newsList.adapter as NewsListAdapter).addItem(articles)
        runLayoutAnimation()
    }

    override fun showLoading() {
        newsList.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun runLayoutAnimation() {

        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom)

        newsList.layoutAnimation = controller
        newsList.adapter.notifyDataSetChanged()
        newsList.scheduleLayoutAnimation()
    }

    override fun showError() {
        context.showToast("error on loading")
    }

    override fun onClicked(pos: Int) {
        Timber.d("onClicked " + (newsList.adapter as NewsListAdapter).getItem(pos).title)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        newsPresenter.onDetach()
    }
}