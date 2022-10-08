package com.example.twitter_compose.presentation.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.twitter_compose.presentation.components.BottomBar
import com.example.twitter_compose.ui.home.HomeScreen
import com.example.twitter_compose.ui.tweet.TweetScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String,
    scrollState: LazyListState
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Screen.HomeFeed.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.TweetFeed.route
        ) {
            TweetScreen(navController = navController)
        }
    }
}

@Composable
fun SetupNavigation(startDestination: String) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val scrollState = rememberLazyListState()
    val state by remember { derivedStateOf { scrollState.firstVisibleItemIndex == 0 } }

    Scaffold(
        bottomBar = {
            if ((currentRoute == Screen.HomeFeed.route && state)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        BottomBar(navController = navController)
                    }
                }
            }
        }
    ) {
        NavigationGraph(
            navController = navController,
            scrollState = scrollState,
            startDestination = startDestination
        )
    }
}
