package com.example.twitter_compose.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.twitter_compose.domain.model.TweetModel
import com.example.twitter_compose.domain.utils.SampleData
import com.example.twitter_compose.presentation.theme.TwitterTheme

@Composable
fun TweetFeed(tweets: List<TweetModel>) {
    LazyColumn {
        items(tweets) { tweet ->
            Tweet(tweet = tweet, null)
        }
    }
}

@Preview
@Composable
fun previewTweetFeed() {
    TwitterTheme {
        TweetFeed(SampleData.tweetSample)
    }
}
