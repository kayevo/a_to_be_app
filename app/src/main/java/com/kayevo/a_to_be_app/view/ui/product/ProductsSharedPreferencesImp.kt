package com.kayevo.a_to_be_app.view.ui.product

import android.annotation.SuppressLint
import android.content.Context
import com.kayevo.a_to_be_app.domain.product.ProductsSharedPreferences

class ProductsSharedPreferencesImp(context: Context) : ProductsSharedPreferences {
    companion object {
        private const val PRODUCTS = "PRODUCTS"
        private const val IS_SAVED = "IS_SAVED"
    }

    private val preferences = context.getSharedPreferences(PRODUCTS, Context.MODE_PRIVATE)

    override suspend fun getIsSaved(): Boolean = preferences.getBoolean(IS_SAVED, false)

    @SuppressLint("UseKtx")
    override suspend fun setIsSaved(isSaved: Boolean) {
        preferences.edit().putBoolean(IS_SAVED, isSaved).apply()
    }
}