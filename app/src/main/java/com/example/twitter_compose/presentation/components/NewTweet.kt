package com.example.twitter_compose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_close_24),
                    contentDescription = "close screen",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            navController.navigate(Screen.HomeFeed.route) {
                                popUpTo(Screen.HomeFeed.route) {
                                    inclusive = true
                                }
                            }
                        }
                )
                Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(30.dp)) {
                    Text(text = "Tweet")
                }
            }
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "profile picture",
                    modifier = Modifier
                        .size(24.dp)
                )
                Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(30.dp)) {
                    Text(text = "Public")
                }
            }
            Row(modifier = Modifier.padding(12.dp)) {
                Spacer(modifier = Modifier.padding(24.dp))
                TextField(value = "", onValueChange = {/*TODO*/}, modifier = Modifier.fillMaxWidth().fillMaxHeight())
            }
        }
    }
}
