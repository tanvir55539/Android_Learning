package com.example.fitnessapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Exercise(

    @DrawableRes val imageResourceId: Int,
    @StringRes val dayNumberId : Int,
    @StringRes val descriptionResId: Int,

    @StringRes val exerciseId: Int,

)
