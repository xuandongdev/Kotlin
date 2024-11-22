package com.example.app30day

import android.content.res.Configuration
import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app30day.ui.theme.App30DayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App30DayTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    App30Day()
                }
            }
        }
    }
}

data class Day(
    val dayNumber: Int,
    val title: String,
    val description: String,
    val imageResId: Int,
    val detail: Int
)

val dayList = listOf(
    Day(
        dayNumber = 1,
        title = "Day 1",
        description = "Unit 1: Your first Android app.",
        imageResId = R.drawable.kt4,
        detail = R.string.day1
    ),
    Day(
        dayNumber = 2,
        title = "Day 2",
        description = "Building app UI.",
        imageResId = R.drawable.kt3,
        detail = R.string.day2
    ),
    Day(
        dayNumber = 3,
        title = "Day 3",
        description = "Display lists and use Material Design.",
        imageResId = R.drawable.kt2,
        detail = R.string.day3
    ),
    Day(
        dayNumber = 4,
        title = "Day 4",
        description = "Navigation and app architecture.",
        imageResId = R.drawable.kt1,
        detail = R.string.day4
    ),
    Day(
        dayNumber = 5,
        title = "Day 5",
        description = "Connect to the internet.",
        imageResId = R.drawable.kt7,
        detail = R.string.day5
    ),
    Day(
        dayNumber = 6,
        title = "Day 6",
        description = "Data persistence.",
        imageResId = R.drawable.kt8,
        detail = R.string.day6
    ),
    Day(
        dayNumber = 7,
        title = "Day 7",
        description = "WorkManager.",
        imageResId = R.drawable.kt9,
        detail = R.string.day7
    )
)
@Composable
fun App30Day() {
    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Red)
                    .padding(vertical = 16.dp)

            ) {
                Text(
                    text = "7 Ngày tự học Kotlin",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
        items(dayList) {day->
            DayCard(day)
        }
    }
}

@Composable
fun DayCard(day: Day) {
    val detailString = stringResource(id = day.detail)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = day.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = day.description, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = day.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(8.dp)
            )
            Text(text = detailString, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
@Preview(showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    App30Day()
}