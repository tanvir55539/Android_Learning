package com.example.cardapp

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardapp.ui.theme.CardAppTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting("Android")
//                    CardScreen()
                    MyCard(name = "Tanvir Ahmed", title = "Android Developer", background = Color(0xFFc3e3bc)) //0xFFc3e3bc , 0xFFBEE1BE
                }
            }
        }
    }
}




@Composable
fun MyCard(name: String, title: String, modifier: Modifier = Modifier,background: Color) {

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(8.dp)
            .background(background)
            .fillMaxSize()) {
        val myImage = painterResource(R.drawable.photo_2024_07_12_15_10_34)
        val logo = painterResource(R.drawable.android_logo)

        Image(painter = logo , contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
//                .width(200.dp)
                .height(120.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(text = "Powered by Android", color = Color.Black)


        Image(
            painter = myImage,
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .width(150.dp)
                .height(120.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = name,
            color = Color.Black,
            fontSize = 30.sp,
//            fontWeight = FontWeight.Bold,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Text(text = title,
            color = Color.Black,
            modifier = modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )


        Spacer(modifier = Modifier.height(100.dp))

        Column {
            ContactInfo(
                phone = "+880 1838113048",
                share = "@facebook.com",
                mail = "md10vir@gmail.com",
                modifier = Modifier
            )
        }



    }
}


@Composable
fun ContactInfo(phone: String, share: String, mail: String, modifier: Modifier ){

    Column(modifier = modifier.padding(8.dp)){

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)) {
            Icon(imageVector = Icons.Default.Call, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = phone, color = Color.Black)
        }

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)) {
            Icon(imageVector = Icons.Default.Share, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = share, color = Color.Black)
        }

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)) {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = mail, color = Color.Black)
        }

    }

    
}



@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    CardAppTheme {
        MyCard(name = "Tanvir Ahmed", title = "Android Developer" , background = Color(0xFFc3e3bc))
//        CardScreen()
    }
}