package com.kayevo.a_to_be_app.di

import com.kayevo.a_to_be_app.data.product.ProductDataSource
import com.kayevo.a_to_be_app.data.product.ProductDataSourceImp
import com.kayevo.a_to_be_app.data.product.ProductRepositoryImp
import com.kayevo.a_to_be_app.domain.product.GetAreProductsSavedUseCase
import com.kayevo.a_to_be_app.domain.product.GetProductsUseCase
import com.kayevo.a_to_be_app.domain.product.ProductRepository
import com.kayevo.a_to_be_app.domain.product.ProductsSharedPreferences
import com.kayevo.a_to_be_app.domain.product.SetAreProductsSavedUseCase
import com.kayevo.a_to_be_app.view.ui.account.CreateAccountViewModel
import com.kayevo.a_to_be_app.view.ui.product.ProductsSharedPreferencesImp
import com.kayevo.a_to_be_app.view.ui.product.ProductsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Create account
    viewModel { CreateAccountViewModel() }

    // Products
    single<ProductDataSource> { ProductDataSourceImp(get()) }
    single<ProductRepository> { ProductRepositoryImp(get()) }
    single<ProductsSharedPreferences> { ProductsSharedPreferencesImp(androidContext()) }
    single { GetProductsUseCase(get()) }
    single { GetAreProductsSavedUseCase(get()) }
    single { SetAreProductsSavedUseCase(get()) }
    viewModel { ProductsViewModel(get(), get(), get()) }
}

