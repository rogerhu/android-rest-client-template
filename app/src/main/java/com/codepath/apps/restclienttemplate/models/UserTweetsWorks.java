package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UserTweetsWorks {
    @Embedded
    User user;

    @Relation(parentColumn = "userId", entityColumn = "id", entity=Tweet.class)
    List<Tweet> tweets;
}
