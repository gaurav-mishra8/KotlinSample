package com.greenbot.juniper.domain.data.news;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by gaurav on 20/7/17.
 */
@Dao
public interface NewsDAO {

    @Query("SELECT * FROM News")
    List<NewsEntity> getNews();

    @Insert
    void insertAll(List<NewsEntity> newsEntities);

    @Insert
    void insert(NewsEntity newsEntity);
}
