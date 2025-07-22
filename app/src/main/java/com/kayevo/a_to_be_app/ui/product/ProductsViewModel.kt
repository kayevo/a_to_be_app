package com.kayevo.a_to_be_app.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kayevo.a_to_be_app.domain.product.GetProductsUseCase
import com.kayevo.a_to_be_app.domain.product.Product
import com.kayevo.a_to_be_app.domain.result.ServiceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products: StateFlow<List<Product>> = _products

    init {
        viewModelScope.launch {
            getProductsUseCase().collect{ productsResponse ->
                when(productsResponse){
                    is ServiceResult.Success -> {
                        _products.value = productsResponse.data
                    }

                    ServiceResult.Error -> { /* TODO */ }
                    ServiceResult.Loading -> { /* TODO */ }
                }

            }
        }
    }

    suspend fun getMockedProducts(){
        val mockedItems = mutableListOf<Product>()
        for(element in 0..50) mockedItems.add(Product(id = 0, title = "Abc"))

        _products.value = mockedItems
    }
}