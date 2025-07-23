package com.kayevo.a_to_be_app.data.product

import com.kayevo.a_to_be_app.domain.product.Product
import com.kayevo.a_to_be_app.domain.product.ProductRepository
import com.kayevo.a_to_be_app.domain.result.ServiceResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ProductRepositoryImp(private val productDataSource: ProductDataSource): ProductRepository {

    override fun getProducts(): Flow<ServiceResult<List<Product>>> = flow<ServiceResult<List<Product>>> {
        emit(ServiceResult.Loading)
        val productsResponse = productDataSource.getProducts()
        if (productsResponse.isSuccessful) {
            productsResponse.body()?.products?.let { productsDto ->
                val products = productsDto.parseToProduct()
                emit(ServiceResult.Success(products))
            } ?: emit(ServiceResult.Success(emptyList()))
        } else {
            emit(ServiceResult.Error)
        }
    }.catch { _ -> emit(ServiceResult.Error) }

    override fun getAreProductsSaved(): Flow<ServiceResult<Boolean>> = flow<ServiceResult<Boolean>> {
        emit(ServiceResult.Loading)
        val areProductsSaved = productDataSource.getAreProductsSaved()
        emit(ServiceResult.Success(areProductsSaved))
    }.catch { _ -> emit(ServiceResult.Error) }

    override suspend fun setAreProductsSaved(areSaved: Boolean){
        productDataSource.setAreProductsSaved(areSaved)
    }
}

