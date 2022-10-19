package com.example.twitter_compose.ui.home

import com.example.twitter_compose.domain.model.TweetModel
import com.example.twitter_compose.domain.repo.HomeRepository
import com.example.twitter_compose.domain.utils.SampleData

class HomeRepositoryImpl(private val dataSource: SampleData) : HomeRepository {

    override fun getTweetList(): List<TweetModel> {
        return dataSource.tweetSample
    }
}
