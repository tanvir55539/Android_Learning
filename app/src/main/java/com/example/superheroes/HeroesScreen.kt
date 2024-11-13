//package com.example.superheroes
//
//import androidx.annotation.DrawableRes
//import androidx.annotation.StringRes
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.superheroes.model.Heros
//
//@Composable
//fun HeroCard(
//    hero: Heros,
//    modifier : Modifier = Modifier
//){
//
//    Card(modifier = modifier.padding(16.dp)){
//
//        Column(){
//            Row(modifier = modifier
//                .fillMaxWidth()
//
//                ){
//                HeroInformation(hero.nameResId, hero.descriptionResId)
//                HeroIcon(hero.imageResourceId)
//
//
//            }
//
//        }
//    }
//}
//
//
//@Composable
//fun HeroInformation(
//    @StringRes heroName : Int,
//    @StringRes heroDescription : Int,
//    modifier: Modifier = Modifier){
//
//    Row(modifier = modifier) {
//
//        Text(
//            text = stringResource(heroName),
//        style = MaterialTheme.typography.displaySmall,
//            modifier = Modifier.padding(8.dp)
//        )
//        Text(
//            text = stringResource(heroDescription),
//            style = MaterialTheme.typography.bodyLarge
//        )
//    }
//}
//
//
//@Composable
//fun HeroIcon(
//    @DrawableRes heroImage : Int,
//    modifier : Modifier = Modifier
//){
//    Image(
//        modifier = modifier
//            .size(64.dp)
//            .padding(8.dp)
//            .clip(MaterialTheme.shapes.small),
//        contentScale = ContentScale.Crop,
//        painter = painterResource(heroImage),
//        contentDescription =  null
//    )
//
//}
//
//@Preview
//@Composable
//fun heroPreview(){
//    HeroCard(Heros(R.string.hero1,R.string.description1,R.drawable.android_superhero1))
//}