package com.example.twitter_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.twitter_compose.domain.utils.SampleData
import com.example.twitter_compose.presentation.components.TweetFeed
import com.example.twitter_compose.presentation.theme.TwitterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterTheme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    // A surface container using the 'background' color from the theme
    //Tweet(TweetModel("Oskar Programming", "First compose tweet", null))
    TweetFeed(tweets = SampleData.tweetSample)
}
