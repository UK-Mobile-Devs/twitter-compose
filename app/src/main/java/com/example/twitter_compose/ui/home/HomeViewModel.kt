package com.example.twitter_compose.ui.home

import androidx.lifecycle.ViewModel
import com.example.twitter_compose.domain.model.TweetModel

abstract class HomeViewModel : ViewModel() {
    abstract fun getTweets(): List<TweetModel>
}
