package com.example.twitter_compose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.twitter_compose.R
import com.example.twitter_compose.presentation.utils.Screen


@Composable
fun NewTweetScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.primary
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_close_24),
                    contentDescription = "close screen",
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(24.dp)
                        .clickable {
                            navController.navigate(Screen.HomeFeed.route) {
                                popUpTo(Screen.HomeFeed.route) {
                                    inclusive = true
                                }
                            }
                        }
                )
            }
        }
    }
}
