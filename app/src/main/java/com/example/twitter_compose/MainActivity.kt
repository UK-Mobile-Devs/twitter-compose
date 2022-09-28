package com.example.twitter_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twitter_compose.ui.theme.Twitter_composeTheme

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
    Tweet("Tweeeit")
}

@Composable
private fun Tweet(context: String) {
    var expanded = remember { mutableStateOf(false) }
    val verticalPadding = if(expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier.weight(1f)
                    .padding(bottom = verticalPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = context)
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = (if (expanded.value) "Show Me More" else "Show me Less"))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TwitterTheme {
        Tweet("Tweet")
    }
}
