package com.example.fidelity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fidelity.ui.theme.FidelityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FidelityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {
                    MyFidelity()
                }
            }
        }
    }
}

@Composable
fun MyFidelity(){
    Box(modifier = Modifier
        .fillMaxSize()
            .background(Color(0xFFd2e899))
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color(0xFF073042)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(5.dp)
                )
            }
            Text (
                text = "Bui Xuan Dong",
                modifier = Modifier.padding(vertical = 5.dp),
                fontSize = 40.sp
            )
            Text (
                text = "B2203439",
                fontSize = 20.sp,
                color = Color(0xFF006d3b)
            )
        }
        Column (
            modifier = Modifier
                .padding(horizontal = 100.dp, vertical = 30.dp)
                .width(1000.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon (
                    Icons.Default.Call,
                    contentDescription = "phone",
                    modifier = Modifier.padding(end = 16.dp),
                    tint = Color(0xFF006d3b)
                )
                Text (
                    text = "0999 8386 79",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
                    .size(20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Icon (
                    Icons.Default.Person,
                    contentDescription = "social",
                    modifier = Modifier.padding(end = 16.dp),
                    tint = Color(0xFF006d3b)
                )
                Text(
                    text = "@XuanDongDev",
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 100.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Email,
                    contentDescription = "email",
                    modifier = Modifier.padding(end = 16.dp),
                    tint = Color(0xFF006d3b)
                )
                Text(
                    text = "xuandong.contact",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FidelityTheme {
        MyFidelity()
    }
}