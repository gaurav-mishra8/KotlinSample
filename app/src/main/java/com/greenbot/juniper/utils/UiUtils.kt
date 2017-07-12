@file:JvmName("ExtensionUtils")

package com.greenbot.juniper.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import com.greenbot.juniper.R

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
