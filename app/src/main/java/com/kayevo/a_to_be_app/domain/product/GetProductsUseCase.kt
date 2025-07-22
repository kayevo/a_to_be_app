package com.kayevo.a_to_be_app.domain.product

import com.kayevo.a_to_be_app.domain.result.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val productRepository: ProductRepository) {
    operator fun invoke(): Flow<ServiceResult<List<Product>>>{
        return productRepository.getProducts()
    }
}