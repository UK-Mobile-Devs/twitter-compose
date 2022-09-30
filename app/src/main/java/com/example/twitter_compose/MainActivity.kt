package com.example.twitter_compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitter_compose.feature.home.TweetModel
import com.example.twitter_compose.ui.theme.TwitterTheme
import com.example.twitter_compose.utils.SampleData

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

@Composable
private fun Tweet(tweet: TweetModel) {
    var isLiked by remember { mutableStateOf(false) }
    val starStateColour by animateColorAsState(
        if(isLiked) lightColors().surface else darkColors().secondary
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
            Row(modifier = Modifier.padding(12.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(id = R.drawable.ic_reply),
                    colorFilter = ColorFilter.tint(starStateColour),
                    contentDescription = "reply",
                )
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(id = R.drawable.ic_retweet),
                    colorFilter = ColorFilter.tint(starStateColour),
                    contentDescription = "retweet",
                )
                Image(
                    modifier = Modifier.clickable { isLiked = !isLiked },
                    painter = painterResource(id = R.drawable.ic_star),
                    colorFilter = ColorFilter.tint(starStateColour),
                    contentDescription = "like",
                )
            }
        }
    }
}

@Composable
fun TweetFeed(tweets: List<TweetModel>) {
    LazyColumn {
        items(tweets) { tweet ->
            Tweet(tweet = tweet)
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

@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    TwitterTheme {
        Tweet(TweetModel("Oskar Brown", "First compose tweet", null))
    }
}
