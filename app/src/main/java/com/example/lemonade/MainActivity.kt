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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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
                    LemonJuice()
                }
            }
        }
    }
}

@Composable
fun LemonJuice(modifier: Modifier=Modifier){

    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(Color.Yellow),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(stringResource(R.string.lemonade),
                color = Color.Black)
        }

        var lemon by remember { mutableStateOf(1) }

        //    val x =remember{ (3..5).random()}
        var squeezeCount by remember { mutableStateOf(0) }

        var imageresource = when (lemon) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            4 -> R.drawable.lemon_restart
            else -> R.drawable.lemon_tree

        }
        when (lemon) {

            1 -> {
                Column(
                    modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(painter = painterResource(imageresource),
                        contentDescription = "tree",
                        modifier
                            .clickable {
                                lemon = 2
                                squeezeCount = (2..4).random()
                            }
                            .border(
                                width = 3.dp, brush = Brush.sweepGradient(
                                    colors = listOf(
                                        Color.Magenta,
                                        Color.Cyan,
                                        Color.Magenta
                                    ) // Circular gradient
                                ), shape = RoundedCornerShape(30.dp)
                            )

                            .background(
                                MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(30.dp)
                            )
                        //                        .background()


                    )

                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        stringResource(R.string.tap_the_lemon_tree_to_select_a_lemon),
                        modifier = Modifier,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }// 1

            2 -> {
                Column(
                    modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(painter = painterResource(imageresource),
                        contentDescription = "one lemon",
                        modifier
                            .clickable {
                                squeezeCount--
                                if (squeezeCount == 0) {
                                    lemon = 3
                                }
                            }
                            .border(
                                width = 3.dp, brush = Brush.sweepGradient(
                                    colors = listOf(
                                        Color.Magenta,
                                        Color.Cyan,
                                        Color.Magenta
                                    ) // Circular gradient
                                ), shape = RoundedCornerShape(30.dp)
                            )

                            .background(
                                MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(30.dp)
                            )

                    )

                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        stringResource(R.string.keep_tapping_the_lemon_to_squeeze_it),
                        modifier = Modifier,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

            }


            3 -> {
                Column(
                    modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(painter = painterResource(imageresource),
                        contentDescription = "glass of lemon",
                        modifier
                            .clickable {
                                lemon = 4
                            }
                            .border(
                                width = 3.dp, brush = Brush.sweepGradient(
                                    colors = listOf(
                                        Color.Magenta,
                                        Color.Cyan,
                                        Color.Magenta
                                    ) // Circular gradient
                                ), shape = RoundedCornerShape(30.dp)
                            )

                            .background(
                                MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(30.dp)
                            )


                    )

                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        stringResource(R.string.tap_the_lemonade_to_drink_it),
                        modifier = Modifier,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                    )

                }
            }


            4 -> {
                Column(
                    modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(painter = painterResource(imageresource),
                        contentDescription = "make the juice again",
                        modifier
                            .clickable {
                                lemon = 1
                            }
                            .border(
                                width = 3.dp, brush = Brush.sweepGradient(
                                    colors = listOf(
                                        Color.Magenta,
                                        Color.Cyan,
                                        Color.Magenta
                                    ) // Circular gradient
                                ), shape = RoundedCornerShape(30.dp)
                            )

                            .background(
                                MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(30.dp)
                            )


                    )

                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        stringResource(R.string.tap_the_empty_glass_to_start_again),
                        modifier = Modifier,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                    )

                }
            }

        }
    }// when

} // compose


@Preview(showBackground = true,
    showSystemUi = true )
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonJuice()
    }
}