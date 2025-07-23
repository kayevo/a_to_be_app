package com.kayevo.a_to_be_app.view.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kayevo.a_to_be_app.domain.product.GetAreProductsSavedUseCase
import com.kayevo.a_to_be_app.domain.product.GetProductsUseCase
import com.kayevo.a_to_be_app.domain.product.Product
import com.kayevo.a_to_be_app.domain.product.SetAreProductsSavedUseCase
import com.kayevo.a_to_be_app.domain.result.ServiceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val getAreProductsSavedUseCase: GetAreProductsSavedUseCase,
    private val setAreProductsSavedUseCase: SetAreProductsSavedUseCase
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products: StateFlow<List<Product>> = _products

    init {
        viewModelScope.launch {
            displayProducts()
        }
        viewModelScope.launch {
            saveProducts()
        }
    }

    private suspend fun saveProducts(){
        getAreProductsSavedUseCase().collect{ areProductsSaved ->
            when(areProductsSaved){
                is ServiceResult.Success -> {
                    if(!areProductsSaved.data) {
                        getProductsUseCase().collect{ productsResponse ->
                            when(productsResponse){
                                is ServiceResult.Success -> {
                                    // TODO save products, productsResponse.data, with saveProductsUseCase
                                    // Given saved with success, Then call setAreProductsSavedUseCase(true)
                                }

                                ServiceResult.Error -> { /* TODO */ }
                                ServiceResult.Loading -> { /* TODO */ }
                            }

                        }
                    }
                }
                ServiceResult.Error -> { /* TODO */ }
                ServiceResult.Loading -> { /* TODO */ }
            }
        }
    }

    private suspend fun displayProducts(){
        // TODO display products using getSavedProductsUseCase()
    }

    suspend fun getMockedProducts(){
        val mockedItems = mutableListOf<Product>()
        for(element in 0..50) mockedItems.add(Product(id = 0, title = "Abc"))

        _products.value = mockedItems
    }
}