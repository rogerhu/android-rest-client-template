package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.codepath.apps.restclienttemplate.MyDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@Entity
public class Tweet {
    // Define database columns and associated fields
    @PrimaryKey
    Long id;

    @ColumnInfo
    String userId;
    @ColumnInfo
    String userHandle;
    @ColumnInfo
    String timestamp;
    @ColumnInfo
    String body;

    // need a public constructor
    public Tweet() {
        super();
    }

    // Add a constructor that creates an object from the JSON response
    public Tweet(JSONObject object){
        super();

        try {
            this.userId = object.getString("user_id");
            this.userHandle = object.getString("user_username");
            this.timestamp = object.getString("timestamp");
            this.body = object.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Tweet> fromJson(JSONArray jsonArray) {
        ArrayList<Tweet> tweets = new ArrayList<Tweet>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject tweetJson = null;
            try {
                tweetJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Tweet tweet = new Tweet(tweetJson);
            tweets.add(tweet);
        }

        // save later
        return tweets;
    }
}
