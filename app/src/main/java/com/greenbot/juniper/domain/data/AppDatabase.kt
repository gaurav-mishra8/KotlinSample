package com.greenbot.juniper.domain.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.greenbot.juniper.domain.data.news.NewsDAO
import com.greenbot.juniper.domain.data.news.NewsEntity

/**
 * Created by gaurav on 20/7/17.
 */
@Database(entities = arrayOf(NewsEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDAO(): NewsDAO

}
