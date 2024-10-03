package com.example.affirmationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmationsapp.data.Datasource
import com.example.affirmationsapp.model.Affirmation
import com.example.affirmationsapp.ui.theme.AffirmationsAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationApp()

                }
            }
        }
    }
}

@Composable
fun AffirmationApp(){

    val layoutDirection = LocalLayoutDirection.current
    Surface(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            )
    ){
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
        )

            }


}


@Composable
fun AffirmationCard(affirmation: Affirmation,
                    modifier:Modifier = Modifier){

    Card(modifier = modifier) {

        Column {
            Image(painter = painterResource(affirmation.imageResourceId) ,
                contentDescription = stringResource(affirmation.stringResourceId), // this data or text is not shown in the UI from here
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            Text(text = LocalContext.current.getString(affirmation.stringResourceId), // the text is shown in the UI from here
                    modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
                )


        }


    }

}


@Composable
fun AffirmationList(affirmationList: List<Affirmation>,
                    modifier: Modifier = Modifier){

    LazyColumn(modifier = modifier){
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation = affirmation,
                modifier = Modifier.padding(8.dp))

        }

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AffirmationCardPreview() {
//    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
    AffirmationApp()
}