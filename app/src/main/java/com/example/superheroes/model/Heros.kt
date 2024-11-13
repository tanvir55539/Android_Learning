package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Heros(
    @StringRes val nameResId: Int,
    @StringRes val descriptionResId : Int,
    @DrawableRes val imageResourceId: Int,

)
