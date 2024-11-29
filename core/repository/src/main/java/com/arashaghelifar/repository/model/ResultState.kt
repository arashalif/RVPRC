package com.arashaghelifar.repository.model

sealed class ResultState<out T> {
    data object Loading : ResultState<Nothing>()
    data class Success<out T>(val data: T?) : ResultState<T>()
    data class Error(val message: String, val cause: Throwable? = null) : ResultState<Nothing>()
}