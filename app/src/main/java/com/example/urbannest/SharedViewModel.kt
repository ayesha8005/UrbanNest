package com.example.urbannest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<MutableList<FurnitureItem>>(mutableListOf())
    val cartItems: LiveData<MutableList<FurnitureItem>> = _cartItems

    private val _favoriteItems = MutableLiveData<MutableList<FurnitureItem>>(mutableListOf())
    val favoriteItems: LiveData<MutableList<FurnitureItem>> = _favoriteItems

    fun addToCart(item: FurnitureItem) {
        _cartItems.value?.add(item)
        _cartItems.value = _cartItems.value
    }

    fun addToFavorites(item: FurnitureItem) {
        _favoriteItems.value?.add(item)
        _favoriteItems.value = _favoriteItems.value
    }
}

