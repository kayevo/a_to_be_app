package com.kayevo.a_to_be_app.data.product

import com.kayevo.a_to_be_app.data.network.ApiClient
import retrofit2.Response

class ProductDataSourceImp: ProductDataSource {
    private val productService = ApiClient.builder.create(ProductService::class.java)

    override suspend fun getProducts(): Response<ProductsResponse> {
        return productService.getProductsResponse()
    }
}

