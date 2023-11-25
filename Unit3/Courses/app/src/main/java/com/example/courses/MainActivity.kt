package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesList(topicList = DataSource.topics)
                }
            }
        }
    }
}



@Composable
fun CoursesList(
    topicList:List<Topic>,
    modifier: Modifier=Modifier) {
    LazyColumn(modifier=modifier){
        items(topicList) {
            topic ->
            CoursesCard(topic = topic,
                modifier=Modifier
            )
        }
    }

}

@Composable
fun CourseImage(
    topic: Topic,
    modifier: Modifier=Modifier) {
    Image(
        painter = painterResource(topic.imageResourceId),
        contentDescription = stringResource(topic.stringResourceId),
        modifier= modifier
            .height(68.dp)
            .width(68.dp)
    )
}
@Composable
fun CoursesCard(
    topic: Topic,
    modifier: Modifier=Modifier) {
    Card(
        modifier=modifier
    ) {
        Row {
            CourseImage(topic = topic)
            Column {
                Text(
                    text = LocalContext.current.getString(topic.stringResourceId),
                    modifier = modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.mipmap.ic_grain),
                        contentDescription = null,
                        modifier = modifier
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = topic.courseCount.toString(),
                        modifier = modifier
                            .padding(start = 8.dp)
                    )
                }
            }
        }




    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesTheme {
        CoursesCard(Topic(R.string.architecture, 58,R.drawable.architecture))
    }
}