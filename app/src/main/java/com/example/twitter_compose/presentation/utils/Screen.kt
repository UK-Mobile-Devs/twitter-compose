package com.example.twitter_compose.presentation.utils

sealed class Screen(val route: String) {
    object HomeFeed : Screen(route = "home_feed")
    object TweetFeed : Screen(route = "tweet_feed")
}
