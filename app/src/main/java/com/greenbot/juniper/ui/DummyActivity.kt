package com.greenbot.juniper.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.greenbot.juniper.R
import io.supercharge.shimmerlayout.ShimmerLayout

/**
 * Created by gaurav on 22/7/17.
 */
class DummyActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dummy_shimmer_screen)

        val shimmerLayout = findViewById(R.id.shimmer_layout) as ShimmerLayout
        shimmerLayout.startShimmerAnimation()
    }
}