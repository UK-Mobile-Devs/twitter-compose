package com.example.twitter_compose.ui.home

import androidx.lifecycle.ViewModel
import com.example.twitter_compose.domain.model.TweetModel
import com.example.twitter_compose.domain.repo.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeRepository) : ViewModel() {

    fun getTweets(): List<TweetModel> {
        return repo.getTweetList()
    }

}
