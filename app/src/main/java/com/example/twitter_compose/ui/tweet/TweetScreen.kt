package com.example.twitter_compose.ui.tweet

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.twitter_compose.presentation.components.NewTweetScreen


@Composable
fun TweetScreen(navController: NavController) {
    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    NewTweetScreen(navController)
}
