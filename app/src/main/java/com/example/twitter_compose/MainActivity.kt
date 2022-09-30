package com.example.twitter_compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitter_compose.feature.home.TweetModel
import com.example.twitter_compose.ui.theme.TwitterTheme

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
    Tweet(TweetModel("Oskar Programming", "First compose tweet", null))
}

@Composable
private fun Tweet(tweet: TweetModel) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
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
                Text(text = tweet.authorName, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(bottom = 8.dp))
                Text(text = tweet.context)
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
        Tweet(TweetModel("Oskar Brown", "First compose tweet", null))
    }
}
