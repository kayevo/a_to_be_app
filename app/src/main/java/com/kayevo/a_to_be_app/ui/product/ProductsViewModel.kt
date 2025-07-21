package com.kayevo.a_to_be_app.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel() : ViewModel() {
    private val _products = MutableStateFlow<List<String>>(listOf())
    val products: StateFlow<List<String>> = _products

    init {
        viewModelScope.launch {
            getProducts()
        }
    }

    suspend fun getProducts(){
        val mockItems = mutableListOf<String>()
        for(element in 0..50) mockItems.add("Item name")

        _products.value = mockItems
    }
}