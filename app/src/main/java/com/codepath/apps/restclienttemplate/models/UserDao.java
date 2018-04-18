package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User WHERE userId = :id")
    UserTweetsFail byId(long id);  // change to userTweetsWorks to see this pass

    @Query("SELECT * FROM User ORDER BY userId DESC LIMIT 300")
    List<User> recentItems();
}
