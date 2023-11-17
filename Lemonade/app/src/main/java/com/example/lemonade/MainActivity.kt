package com.example.lemonade

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
                    LemonadeApp()
                }
            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(){

    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title =
                {
                    Text(
                        text = "Lemondade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) {
        when (currentStep) {
            1 -> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.step1_body,
                    drawableResourceId = R.drawable.lemon_tree  ,
                    contentDescriptionResourceId = R.string.step1_title,
                    onImageClick = {
                        currentStep=2
                        squeezeCount=(2..4).random()
                    })
            }
            2 -> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.step2_body,
                    drawableResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionResourceId =R.string.step2_title ,
                    onImageClick = {
                        squeezeCount--
                        if(squeezeCount ==0) {
                            currentStep=3
                        }
                    }
                )
            }
            3-> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.step3_body,
                    drawableResourceId = R.drawable.lemon_drink ,
                    contentDescriptionResourceId =R.string.step3_title ,
                    onImageClick = {
                        currentStep=4
                    })
            }
            4 -> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.step4_title,
                    drawableResourceId = R.drawable.lemon_restart,
                    contentDescriptionResourceId =R.string.step4_title ,
                    onImageClick = {
                        currentStep=1
                    })
            }

        }

    }


}


@Composable
fun LemonTextAndImage(
    textLabelResourceId:Int,
    drawableResourceId:Int,
    contentDescriptionResourceId:Int,
    onImageClick: () -> Unit,
    modifier: Modifier=Modifier
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Button(onClick = onImageClick) {
            Image(painter = painterResource(
                id = drawableResourceId),
                contentDescription = stringResource(id = contentDescriptionResourceId),
                modifier= modifier)
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = stringResource(id =textLabelResourceId),
            style = MaterialTheme.typography.bodyLarge)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }

}