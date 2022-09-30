package com.example.twitter_compose.presentation.components

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twitter_compose.R
import com.example.twitter_compose.domain.model.TweetModel
import com.example.twitter_compose.presentation.theme.TwitterTheme


@Composable
fun Tweet(tweet: TweetModel, onLikeClick: () -> Unit) {
    var isLiked by remember { mutableStateOf(false) }
    val starStateColour by animateColorAsState(
        if (isLiked) lightColors().surface else darkColors().secondary
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column {
            Row(modifier = Modifier.padding(12.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_accessibility_new_24),
                    contentDescription = "profile picture",
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(2.5.dp, MaterialTheme.colors.secondary, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = tweet.authorName,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(text = tweet.context)
                }
            }
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    modifier = Modifier.clickable { },
                    painter = painterResource(id = R.drawable.ic_reply),
                    colorFilter = ColorFilter.tint(starStateColour),
                    contentDescription = "reply",
                )
                Image(
                    modifier = Modifier.clickable { },
                    painter = painterResource(id = R.drawable.ic_retweet),
                    colorFilter = ColorFilter.tint(starStateColour),
                    contentDescription = "retweet",
                )
                Image(
                    modifier = Modifier.clickable {
                        isLiked = !isLiked
                        onLikeClick
                    },
                    painter = painterResource(id = R.drawable.ic_star),
                    colorFilter = ColorFilter.tint(starStateColour),
                    contentDescription = "like",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    TwitterTheme {
        Tweet(TweetModel("Oskar Brown", "First compose tweet", null), null)
    }
}
