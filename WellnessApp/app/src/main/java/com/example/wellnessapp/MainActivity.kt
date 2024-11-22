package com.example.wellnessapp

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellnessapp.ui.theme.WellnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WellnessAppTheme{
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                        WellnessApp()
                    }
            }
        }
    }
}

// Data model cho mỗi ngày
data class Day(
    val dayNumber: Int,
    val title: String,
    val description: String,
    val imageResId: Int
)

val dayList = listOf(
    Day(
        dayNumber = 1,
        title = "Day 1",
        description = "Unit 1: Your first Android app.",
        imageResId = R.drawable.kt4
    ),
    Day(
        dayNumber = 2,
        title = "Day 2",
        description = "Building app UI.",
        imageResId = R.drawable.kt3
    ),
    Day(
        dayNumber = 3,
        title = "Day 3",
        description = "Display lists and use Material Design.",
        imageResId = R.drawable.kt2
    ),
    Day(
        dayNumber = 4,
        title = "Day 4",
        description = "Navigation and app architecture.",
        imageResId = R.drawable.kt1
    ),
    Day(
        dayNumber = 5,
        title = "Day 5",
        description = "Connect to the internet.",
        imageResId = R.drawable.kt7
    ),
    Day(
        dayNumber = 6,
        title = "Day 6",
        description = "Data persistence.",
        imageResId = R.drawable.kt8
    ),
    Day(
        dayNumber = 7,
        title = "Day 7",
        description = "WorkManager.",
        imageResId = R.drawable.kt9
    ),
)
@Composable
fun WellnessApp() {
    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Tiêu đề lớn ở trên cùng
        item {
            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1E88E5)) // Màu xanh biển
                    .padding(vertical = 16.dp) // Khoảng cách trên và dưới cho Box

            ) {
                Text(
                    text = "7 Ngày tự học Kotlin",
                    fontSize = 24.sp,
                    color = Color.White, // Màu chữ trắng
                    modifier = Modifier
                        .align(Alignment.Center), // Căn giữa văn bản trong Box
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = day.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = day.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = day.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessAppPreview() {
    WellnessApp()
}
