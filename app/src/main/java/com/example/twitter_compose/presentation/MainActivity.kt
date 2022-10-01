package com.example.twitter_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.twitter_compose.domain.utils.SampleData
import com.example.twitter_compose.presentation.components.TweetFeed
import com.example.twitter_compose.presentation.theme.TwitterTheme
import com.example.twitter_compose.presentation.utils.Screen
import com.example.twitter_compose.presentation.utils.SetupNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterTheme {
                //val screen by splashViewModel.startDestination
                val screen = Screen.HomeFeed.route
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SetupNavigation(
                        startDestination = screen
                    )
                }
            }
        }
    }
}
