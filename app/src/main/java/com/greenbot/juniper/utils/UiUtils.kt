@file:JvmName("ExtensionUtils")

package com.greenbot.juniper.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import butterknife.ButterKnife
import com.greenbot.juniper.R
import com.squareup.picasso.Picasso

/**
 * Created by gaurav on 9/7/17.
 */

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.setupActionBar(title: String) {
    setSupportActionBar(ButterKnife.findById<Toolbar>(this, R.id.app_bar))

    supportActionBar?.also {
        it.title = title
    }

}

fun AppCompatActivity.addFragemnt(containerId: Int, fragment: Fragment) {

    checkNotNull(fragment)

    supportFragmentManager.beginTransaction()
            .add(containerId, fragment)
            .commit()

}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false) =
        with(this) {
            LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
        }

fun ImageView.loadUrl(imageUrl: String) {

    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.with(context).load(imageUrl).into(this)
    }

}
