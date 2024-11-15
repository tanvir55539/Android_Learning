package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.model.Exercise
import com.example.fitnessapp.model.ExerciseData
import com.example.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Pass exercise data to the UI
                    FitnessAppUI(exercise = ExerciseData.exercisePlan)
                }
            }
        }
    }
}

@Composable
fun FitnessAppUI(exercise: List<Exercise>) {
    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.4f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.main), // Replace with your image resource
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "30 Days of Fitness",
                    style = MaterialTheme.typography.displayLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Transform Your Life One Day at a Time",
                    style = MaterialTheme.typography.headlineLarge.copy(color = Color.White),
                )
                Spacer(modifier = Modifier.height(16.dp))
//                Button(onClick = { /* Handle button click */ }) {
//                    Text("Get Started")
//                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Day Cards Section
        Text(
            text = "30 Days of Fitness",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(exercise.size) { index ->
                    val currentExercise = exercise[index]
                    FitnessDayCard(
                        dayNumber = index + 1,
                        exerciseDescription = currentExercise.descriptionResId,
                        imageResourceId = currentExercise.imageResourceId
                    )
                }
            }
        )
    }
}

@Composable
fun FitnessDayCard(
    dayNumber: Int,
    @StringRes exerciseDescription: Int,
    @DrawableRes imageResourceId: Int
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageResourceId), // Use the passed image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Day $dayNumber",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black ,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = stringResource(exerciseDescription),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessAppTheme {
        FitnessAppUI(exercise = ExerciseData.exercisePlan)
    }
}
