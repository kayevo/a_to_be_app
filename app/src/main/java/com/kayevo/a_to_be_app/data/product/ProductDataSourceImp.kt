package com.kayevo.a_to_be_app.data.product

import com.kayevo.a_to_be_app.data.network.ApiClient
import com.kayevo.a_to_be_app.domain.product.ProductsSharedPreferences
import retrofit2.Response

class ProductDataSourceImp(
    private val productsSharedPreferences: ProductsSharedPreferences
): ProductDataSource {
    private val productService = ApiClient.builder.create(ProductService::class.java)

    override suspend fun getProducts(): Response<ProductsResponse> = productService
        .getProductsResponse()

    override suspend fun getAreProductsSaved(): Boolean = productsSharedPreferences
        .getIsSaved()

    override suspend fun setAreProductsSaved(areSaved: Boolean) {
        productsSharedPreferences.setIsSaved(areSaved)
    }
}

