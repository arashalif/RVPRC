package com.arashaghelifar.datasource.model

data class RVResponse<T>(
    val status:String,
    val message : String,
    val data: T? = null
)
