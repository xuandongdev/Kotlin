package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(){
    var current by remember {
        mutableStateOf(1)
    }
    var squeezeCounting by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade App",
                        fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) {
        innerPadding -> 
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when(current){
                1->{
                    LemonadeInfo(
                        textLableResourseID = R.string.select,
                        drawableResourceID = R.drawable.lemon_tree,
                        contentDiscriptionID = R.string.select_discription,
                        onImageClick = {
                            current = 2
                            squeezeCounting = (2..4).random()
                        }
                    )
                }
                2->{
                    LemonadeInfo(
                        textLableResourseID = R.string.squeeze,
                        drawableResourceID = R.drawable.lemon_squeeze,
                        contentDiscriptionID = R.string.squeeze_discription,
                        onImageClick = {
                            squeezeCounting--
                            if (squeezeCounting == 0){
                                current = 3
                            }
                        })
                }
                3->{
                    LemonadeInfo(
                        textLableResourseID = R.string.drink,
                        drawableResourceID = R.drawable.lemon_drink,
                        contentDiscriptionID = R.string.drink_discription,
                        onImageClick = {
                            current = 4
                        })
                }
                4->{
                    LemonadeInfo(
                        textLableResourseID = R.string.empty,
                        drawableResourceID = R.drawable.lemon_restart,
                        contentDiscriptionID = R.string.empty_discription,
                        onImageClick = {
                            current = 1
                        })
                }
            }
        }
    }
}

@Composable
fun LemonadeInfo(
    textLableResourseID: Int,
    drawableResourceID: Int,
    contentDiscriptionID: Int,
    onImageClick: ()->Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onImageClick,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme
                    .colorScheme
                    .tertiaryContainer
                )
            ) {
                Image(painter = painterResource(drawableResourceID)
                    ,contentDescription = stringResource(contentDiscriptionID),
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = stringResource(textLableResourseID),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
@Preview
@Composable
fun LemonadeSqueeze(){
    LemonadeApp()
}