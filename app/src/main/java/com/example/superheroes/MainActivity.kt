package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Heros
import com.example.superheroes.ui.theme.SuperheroesTheme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.HeroesRepository.hero

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        HeroApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroApp(){
    Scaffold(

        topBar = {

            TopAppBar()

        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(hero) {
                HeroCard(
                    hero = it,
                    modifier = Modifier.padding(8.dp)
                )

            }

        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun TopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(  verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )

            }
        },
        modifier = modifier
    )
}





@Composable
fun HeroCard(
    hero: Heros,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp), // Rounded corners
//        elevation = 2.dp // Elevation of the card
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // General padding inside the card
        ) {
            HeroInformation(
                heroName = hero.nameResId,
                heroDescription = hero.descriptionResId,
                modifier = Modifier.weight(1f) // Makes the text column fill the remaining space
            )

            Spacer(modifier = Modifier.width(16.dp)) // Space between text and image

            HeroIcon(
                heroImage = hero.imageResourceId,
                modifier = Modifier.size(72.dp) // Set size according to the image
            )
        }
    }
}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(bottom = 8.dp) // Padding below the title
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroImage: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp)), // Rounded corners for the image
        contentScale = ContentScale.Crop,
        painter = painterResource(heroImage),
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
//        HeroCard(Heros(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
        HeroApp()
    }
}
