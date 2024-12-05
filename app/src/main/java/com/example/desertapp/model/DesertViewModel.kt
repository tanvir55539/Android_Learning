package com.example.desertapp.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DessertViewModel(desserts: List<Dessert>) : ViewModel() {
    var revenue = mutableStateOf(0)
        private set
    var dessertsSold = mutableStateOf(0)
        private set
    var currentDessert = mutableStateOf(desserts.first())
        private set

    private val dessertList = desserts

    fun onDessertClicked() {
        // Update the revenue
        revenue.value += currentDessert.value.price
        dessertsSold.value++

        // Update the current dessert
        currentDessert.value = determineDessertToShow(dessertList, dessertsSold.value)
    }

    private fun determineDessertToShow(desserts: List<Dessert>, dessertsSold: Int): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }
        return dessertToShow
    }
}


class DessertViewModelFactory(
    private val desserts: List<Dessert>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DessertViewModel::class.java)) {
            return DessertViewModel(desserts) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}