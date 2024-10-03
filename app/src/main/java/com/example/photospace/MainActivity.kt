package com.example.photospace

import android.os.Bundle
import android.text.BoringLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photospace.ui.theme.PhotoSpaceTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PhotoSpace()
                }
            }
        }
    }
}

@Composable
fun PhotoSpace(modifier: Modifier = Modifier) {

    val img1 = R.drawable.pic_1
    val img2 = R.drawable.pic_2
    val img3 = R.drawable.pic_3
    val img4 = R.drawable.pic_4
    val img5 = R.drawable.pic_5

    var picture by remember { mutableStateOf(1) }

  Row(modifier = Modifier
      .fillMaxWidth()
      .background(Color.Gray),
      horizontalArrangement = Arrangement.Center,
      ) {
      Text("Photo Space",
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp
//         
//          modifier.fillMaxWidth()
//              .align(Alignment.CenterVertically)
          )
  }

//Spacer(modifier = Modifier.height(20.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween // Ensure the content is spaced evenly
    ) {
        when (picture) {
            1 -> {
//                Column(modifier=Modifier.wrapContentWidth(Alignment.CenterHorizontally)) {

                Image(
                    painter = painterResource(img1),
                    contentDescription = "First Image",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(start = 35.dp, top = 150.dp, end = 35.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    stringResource(R.string.patenga_see_beach),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    stringResource(R.string.date_13_2_2022),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )


//            }
            }
            2 -> {
                Image(
                    painter = painterResource(img2),
                    contentDescription = "Second Image",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(start = 35.dp, top = 150.dp, end = 35.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    stringResource(R.string.kaptai_lake),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    "Date: 23/5/2023",
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            3 -> {
                Image(
                    painter = painterResource(img3),
                    contentDescription = "Third Image",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(start = 35.dp, top = 150.dp, end = 35.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Kaptai Lake And Hill",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    "Date: 12/7/2021",
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            4 -> {
                Image(
                    painter = painterResource(img4),
                    contentDescription = "Fourth Image",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(start = 35.dp, top = 150.dp, end = 35.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Lake of Rangamati",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    "Date: 18/9/2022",
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            5 -> {
                Image(
                    painter = painterResource(img5),
                    contentDescription = "Fifth Image",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(start = 35.dp, top = 150.dp, end = 35.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Boats in Lake",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    "Date: 12/8/2021",
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }


        // Add a Spacer to push the buttons to the bottom
        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                picture--
                if (picture < 1) {
                    picture = 5
                }
            }) {
                Text(text = "Previous", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Button(onClick = {
                picture++
                if (picture > 5) {
                    picture = 1
                }
            }) {
                Text(text = "    Next    ", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PhotoSpaceTheme {
        PhotoSpace()
    }
}
