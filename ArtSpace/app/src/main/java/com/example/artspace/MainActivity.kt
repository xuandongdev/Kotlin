package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(){
    var hienTai by remember { mutableStateOf(1) }
    when (hienTai){
        1 -> ArtInfo(R.drawable.panamera, "Porsche Panamera", "Porsche")
        2 -> ArtInfo(R.drawable.carrera, "Porsche Carrera", "Porsche")
        3 -> ArtInfo(R.drawable.taycan, "Porsche Taycan", "Porsche")
        else -> ArtInfo(R.drawable.panamera, "Porsche Panamera", "Porsche")
    }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 650.dp)
    ) {
        Button(
            onClick = {
                when(hienTai){
                1 -> hienTai = 3
                2 -> hienTai = 1
                3 -> hienTai = 2
                }},
            border = BorderStroke(2.dp, Color.Gray),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Quay Lại")
        }
        Button(
            onClick = { when(hienTai){
                1 -> hienTai = 2
                2 -> hienTai = 3
                3 -> hienTai = 1
            }},
            border = BorderStroke(2.dp, Color.Gray),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Kế Tiếp")
        }
    }
}
@Composable
fun ArtInfo(
    ArtPicture: Int,
    ArtTitle: String,
    ArtistName: String,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Image(
            painter = painterResource(id = ArtPicture),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .height(200.dp)
                .width(300.dp)
                .padding(10.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .shadow(elevation = 5.dp)
                .padding(10.dp)
        )
        Card(
            modifier = Modifier
                .padding(horizontal = 45.dp, vertical = 90.dp),


        ){
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = ArtTitle,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 30.sp
                )
                Text(
                    text = ArtistName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpace()
}