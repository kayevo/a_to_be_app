package com.kayevo.a_to_be_app.domain.product

import com.kayevo.a_to_be_app.domain.result.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetAreProductsSavedUseCase(
    private val productRepository: ProductRepository
) {
    operator fun invoke(): Flow<ServiceResult<Boolean>> = productRepository.getAreProductsSaved()
}