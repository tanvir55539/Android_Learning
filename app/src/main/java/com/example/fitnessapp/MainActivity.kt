package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha

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
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {

        // Header Section (unchanged)
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
                    var expanded by remember { mutableStateOf(false) }

                    FitnessDayCard(
                        dayNumber = index + 1,
                        imageResourceId = currentExercise.imageResourceId,
                        exerciseDescription = currentExercise.descriptionResId,
                        exerciseId = currentExercise.exerciseId,
                        expanded = expanded,
                        onClick = {
                            expanded = !expanded // Toggle description visibility
                        }
                    )
                }
            }
        )
    }
}



@Composable
fun FitnessDayCard(
    dayNumber: Int,
    @DrawableRes imageResourceId: Int,
    @StringRes exerciseDescription: Int,
    @StringRes exerciseId: Int,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
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
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text= stringResource(id = exerciseId),
                style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black
        )
        )

        // Show description with animation
        if (expanded) {
            AnimatedDescription(exerciseDescription = exerciseDescription)
        }
    }
}

@Composable
fun AnimatedDescription(@StringRes exerciseDescription: Int, modifier: Modifier = Modifier) {
    // Spring animation for height and opacity
    val springHeight by animateDpAsState(
        targetValue = if (exerciseDescription != 0) 100.dp else 0.dp,
        animationSpec = spring(dampingRatio = 0.5f, stiffness = 300f)
    )

    val alpha by animateFloatAsState(
        targetValue = if (exerciseDescription != 0) 1f else 0f,
        animationSpec = spring(dampingRatio = 0.5f, stiffness = 300f)
    )

    // Show description with animated height and opacity
    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 0.dp, max = springHeight) // Animate the height
            .alpha(alpha) // Animate the opacity
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(id = exerciseDescription),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Black
            )
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
