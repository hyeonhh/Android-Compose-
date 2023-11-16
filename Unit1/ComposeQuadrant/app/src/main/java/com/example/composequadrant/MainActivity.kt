package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeCard()
                }
            }
        }
    }
}

@Composable
fun ComposeCard(modifier: Modifier=Modifier) {


    Column {
        Row(
            modifier=modifier,
        ) {

            createCard(
                titleText = "Text composable",
                bodyText = "Displays text and follows the recommended Material Design guidelines.",
                color = Color(0xFFEADDFF),
                modifier=modifier
                    .weight(1f)

            )
            createCard(
                titleText = "Image composable",
                bodyText = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color(0xFFD0BCFF),
                modifier=modifier
                    .weight(1f)

            )

        }

        Row {
            createCard(
                titleText = "Row composable",
                bodyText = "A layout composable that places its children in a horizontal sequence.",
                color = Color(0xFFB69DF8),
                modifier=modifier
                    .weight(1f)

            )
            createCard(
                titleText = "Column composable",
                bodyText = "A layout composable that places its children in a vertical sequence.",
                color = Color(0xFFF6EDFF),
                modifier=modifier
                    .weight(1f)

            )
        }
    }
}

@Composable
fun createCard(titleText: String ,bodyText:String,color:Color, modifier: Modifier=Modifier) {
    Column(
        modifier = modifier
            .background(
                color
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text =titleText,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = bodyText
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeCard()
    }
}