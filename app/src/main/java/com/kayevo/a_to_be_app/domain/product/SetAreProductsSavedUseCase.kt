package com.kayevo.a_to_be_app.domain.product

class SetAreProductsSavedUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(areSaved: Boolean) {
        productRepository.setAreProductsSaved(areSaved)
    }
}