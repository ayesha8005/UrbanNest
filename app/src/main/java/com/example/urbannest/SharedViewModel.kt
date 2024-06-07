package com.example.urbannest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    // LiveData to hold the list of items in the cart
    private val _cartItems = MutableLiveData<MutableList<FurnitureItem>>(mutableListOf())
    val cartItems: LiveData<MutableList<FurnitureItem>> = _cartItems

    // LiveData to hold the list of items in the favorites
    private val _favoriteItems = MutableLiveData<MutableList<FurnitureItem>>(mutableListOf())
    val favoriteItems: LiveData<MutableList<FurnitureItem>> = _favoriteItems

    // Function to add an item to the cart
    fun addToCart(item: FurnitureItem) {
        // Add the item to the current list of cart items
        _cartItems.value?.add(item)
        // Update the LiveData to notify observers
        _cartItems.value = _cartItems.value
    }

    // Function to add an item to the favorites
    fun addToFavorites(item: FurnitureItem) {
        // Add the item to the current list of favorite items
        _favoriteItems.value?.add(item)
        // Update the LiveData to notify observers
        _favoriteItems.value = _favoriteItems.value
    }
}

