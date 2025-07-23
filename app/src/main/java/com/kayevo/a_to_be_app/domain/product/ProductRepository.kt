package com.kayevo.a_to_be_app.domain.product

import com.kayevo.a_to_be_app.domain.result.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<ServiceResult<List<Product>>>
    fun getAreProductsSaved(): Flow<ServiceResult<Boolean>>
    suspend fun setAreProductsSaved(areSaved: Boolean)
}