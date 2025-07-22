package com.kayevo.a_to_be_app.data.product

import retrofit2.Response

interface ProductDataSource {
    suspend fun getProducts(): Response<ProductsResponse>
}