package com.kayevo.a_to_be_app.domain.product

interface ProductsSharedPreferences {
    suspend fun getIsSaved(): Boolean
    suspend fun setIsSaved(isSaved: Boolean)
}