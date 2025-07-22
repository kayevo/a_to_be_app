package com.kayevo.a_to_be_app.domain.result

sealed class ServiceResult<out T> {
    object Loading : ServiceResult<Nothing>()
    data class Success<T>(val data: T) : ServiceResult<T>()
    object Error : ServiceResult<Nothing>()
}