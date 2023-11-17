package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    makingLemonade(stringResource(id = R.string.step1_title)
                         )
                }
            }
        }
    }
}



@Composable
fun makingLemonade(
    contentText: String,
    modifier: Modifier=Modifier.padding(16.dp)) {

    var isClicked by remember { mutableStateOf(1) }
    var randomLemon=(2..4).random()
    var squeezedLemon by remember { mutableStateOf(randomLemon)
    }
    var tabCountNow by remember {
        mutableStateOf(0)
    }


    val imageResource = when (isClicked) {
        1-> R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        else->R.drawable.lemon_restart
    }

    val textResource = when (isClicked) {
        1 -> R.string.step1_body
        2 ->R.string.step2_body
        3 -> R.string.step3_body
        else -> R.string.step4_body
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentText,
            contentScale= ContentScale.Crop,
            modifier= modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF92B8B1))
                .clickable {
                    if (isClicked == 2) {
                        //todo : tabcount만큼 클릭이 되면
                        if (squeezedLemon == tabCountNow) isClicked = 3
                        else tabCountNow++

                    }
                    if (isClicked == 4) {
                        isClicked = 1
                    } else {
                        isClicked++
                    }


                }

        )
        Spacer(modifier = modifier
            .padding(16.dp)
        )
        Text(
            text = stringResource(id = textResource),
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier=modifier
                .align(Alignment.CenterHorizontally)
        )
    }



}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        makingLemonade(stringResource(id = R.string.step1_title))
    }

}