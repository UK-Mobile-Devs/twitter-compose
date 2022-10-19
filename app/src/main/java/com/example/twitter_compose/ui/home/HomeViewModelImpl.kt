package com.example.twitter_compose.ui.home

import com.example.twitter_compose.domain.model.TweetModel
import com.example.twitter_compose.domain.repo.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(private val repo: HomeRepository) : HomeViewModel() {

    override fun getTweets(): List<TweetModel> {
        return repo.getTweetList()
    }

}
