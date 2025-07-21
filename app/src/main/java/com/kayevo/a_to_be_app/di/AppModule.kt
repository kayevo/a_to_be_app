package com.kayevo.a_to_be_app.di

import com.kayevo.a_to_be_app.ui.account.CreateAccountViewModel
import com.kayevo.a_to_be_app.ui.product.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CreateAccountViewModel() }
    viewModel { ProductsViewModel() }
}

