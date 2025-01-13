package com.dodo.litkeep.data.remote

import retrofit2.Response

sealed class ApiResult<T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error<T>(val message: String, val throwable: Throwable? = null) : ApiResult<T>()
}

suspend fun <T> Response<T>.handleApiResponse(): ApiResult<T> {
    return if (this.isSuccessful) {
        val body = this.body()
        if (body != null) {
            ApiResult.Success(body)
        } else {
            ApiResult.Error("Response body is null")
        }
    } else {
        ApiResult.Error("API call failed: ${this.errorBody()?.string()}")
    }
}