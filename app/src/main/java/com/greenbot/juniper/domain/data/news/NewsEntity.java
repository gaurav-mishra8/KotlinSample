package com.greenbot.juniper.domain.data.news;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by gaurav on 20/7/17.
 */
@Entity(tableName = "News")
public class NewsEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "newsId")
    public long id;

    @ColumnInfo(name = "author")
    public String author;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "imageUrl")
    String imageUrl;

    @ColumnInfo(name = "description")
    String description;

    @ColumnInfo(name = "url")
    String url;
}
