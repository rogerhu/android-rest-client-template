package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TweetDao {

    @Query("SELECT * FROM Tweet WHERE id = :id")
    public abstract Tweet byId(long id);

    @Query("SELECT * FROM Tweet ORDER BY ID DESC LIMIT 300")
    public abstract List<Tweet> recentItems();

    @Insert
    public abstract void insert(Tweet tweet);
}
