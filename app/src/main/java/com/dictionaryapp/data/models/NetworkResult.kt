package com.dictionaryapp.data.models


sealed class NetworkResult<out T> {
    object Loading : NetworkResult<Nothing>()
    data class Fail(val message: String) : NetworkResult<Nothing>()
    data class Success<T>(val data: T) : NetworkResult<T>()
}