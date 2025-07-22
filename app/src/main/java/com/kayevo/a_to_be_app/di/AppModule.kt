package com.kayevo.a_to_be_app.di

import com.kayevo.a_to_be_app.data.product.ProductDataSource
import com.kayevo.a_to_be_app.data.product.ProductDataSourceImp
import com.kayevo.a_to_be_app.data.product.ProductRepositoryImp
import com.kayevo.a_to_be_app.domain.product.GetProductsUseCase
import com.kayevo.a_to_be_app.domain.product.ProductRepository
import com.kayevo.a_to_be_app.ui.account.CreateAccountViewModel
import com.kayevo.a_to_be_app.ui.product.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Create account
    viewModel { CreateAccountViewModel() }

    // Products
    single<ProductDataSource> { ProductDataSourceImp() }
    single<ProductRepository> { ProductRepositoryImp(get()) }
    single { GetProductsUseCase(get()) }
    viewModel { ProductsViewModel(get()) }
}

