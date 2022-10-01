package com.example.twitter_compose.ui.home

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.twitter_compose.domain.utils.SampleData
import com.example.twitter_compose.presentation.components.TweetFeed


@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    //val homeScreenState by viewModel.homeScreenState

    TweetFeed(tweets = SampleData.tweetSample) { onItemLiked() }
}

fun onItemLiked(){

}

