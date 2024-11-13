package com.example.superheroes.model

import com.example.superheroes.R

object HeroesRepository{ // here The object keyword in Kotlin is used to create a singleton. A singleton is a class that has only one instance throughout the lifetime of an application.

    val hero = listOf(

        Heros(
            nameResId = R.string.hero1,
            descriptionResId = R.string.description1,
            imageResourceId = R.drawable.android_superhero1
        ),
        Heros(
            nameResId = R.string.hero2,
            descriptionResId = R.string.description2,
            imageResourceId = R.drawable.android_superhero2
        ),
        Heros(
            nameResId = R.string.hero3,
            descriptionResId = R.string.description3,
            imageResourceId = R.drawable.android_superhero3
        ),
        Heros(
            nameResId = R.string.hero4,
            descriptionResId = R.string.description4,
            imageResourceId = R.drawable.android_superhero4
        ),
        Heros(
            nameResId = R.string.hero5,
            descriptionResId = R.string.description5,
            imageResourceId = R.drawable.android_superhero5
        ),
        Heros(
            nameResId = R.string.hero6,
            descriptionResId = R.string.description6,
            imageResourceId = R.drawable.android_superhero6
        ),
    )
}