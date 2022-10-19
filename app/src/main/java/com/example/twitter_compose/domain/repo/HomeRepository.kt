package com.example.twitter_compose.domain.repo

import com.example.twitter_compose.domain.model.TweetModel

interface HomeRepository {
    fun getTweetList(): List<TweetModel>
}
