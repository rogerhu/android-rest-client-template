package com.codepath.apps.restclienttemplate.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

class UserTweetsFail {
    @Embedded var user: User? = null
    @Relation(parentColumn = "userId", entityColumn = "id", entity=Tweet::class)
    var tweets: List<Tweet> = listOf()

}