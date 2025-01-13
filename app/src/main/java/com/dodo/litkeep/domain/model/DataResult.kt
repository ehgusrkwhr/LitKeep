package com.dodo.litkeep.domain.model

sealed class DataResult<out T> {
    data class Success<out T>(val data: T?, val timestamp: Long = System.currentTimeMillis()) : DataResult<T>()
    data class Error(val errorMessage: String?, val timestamp: Long = System.currentTimeMillis()) : DataResult<Nothing>()
    object Loading : DataResult<Nothing>()
    object Uninitialized : DataResult<Nothing>()
}