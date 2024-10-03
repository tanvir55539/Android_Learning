package com.example.shoppinglistapp

import androidx.compose.ui.graphics.FilterQuality
import androidx.lifecycle.ViewModel


data class shoppingItem(val id:Int,
                        var name:String,
                        var quantity:Int,
                        var isEditing:Boolean=false)



class ShoppingListViewModel : ViewModel() {

    private var _items = mutableListOf<shoppingItem>()
    val items: List<shoppingItem> get() = _items

    fun addItem(item: shoppingItem){
        _items.add(item)
    }

    fun removeItem(item: shoppingItem){
        _items.remove(item)
    }
    fun updateItem(id: Int, name: String, quantity: Int){
        _items.find {it.id == id}?.let {
            it.name = name
            it.quantity = quantity
        }
    }

    fun toggleEditItem(id: Int, isEditing: Boolean){
        _items.find { it.id == id}?.isEditing = isEditing
    }

}

