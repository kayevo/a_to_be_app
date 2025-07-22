package com.kayevo.a_to_be_app.data.product

import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProductsResponse(): Response<ProductsResponse>
}