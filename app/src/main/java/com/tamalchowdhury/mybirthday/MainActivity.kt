package com.tamalchowdhury.mybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tamalchowdhury.mybirthday.ui.theme.MyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(message = "Edith", from = "Tamal")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.birthdayparty)


    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithName(message = "Edith", from = "Tamal")
    }


}

@Composable
fun BirthdayGreetingWithName(message: String, from: String) {
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
    )
{
    Text(
        text = stringResource(R.string.happy_birthday_edith),
        fontSize = 36.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(
        text = "-from $from",
        fontSize = 24.sp,
        modifier = Modifier
            .padding(top = 16.dp, end = 16.dp)
            .align(alignment = Alignment.End)
    )
}
    
}

@Preview(showBackground = true, name = "Image Preview")
@Composable
fun ImagePreview() {
    MyBirthdayTheme() {
        BirthdayGreetingWithImage(message = "Edith", from = "Tamal")
    }
}

@Preview(showBackground = true, name = "Main Preview")
@Composable
fun BirthdayGreetingPreview() {
    MyBirthdayTheme() {
        BirthdayGreetingWithName(message = "Edith", from = "Tamal")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBirthdayTheme {
        Greeting("Android")
    }
}