package com.codepath.apps.restclienttemplate;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;
import com.codepath.apps.restclienttemplate.models.UserDao;

@Database(entities= {User.class, Tweet.class}, version=1)
public abstract class MyDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "mydb";

    public abstract UserDao sampleModelDao();
}
