package com.arashaghelifar.datasource.model

import com.google.gson.annotations.SerializedName

data class VideoUpdateRequest(
    @SerializedName("title")
    val title : String,
    @SerializedName("description")
    val description : String,
)
