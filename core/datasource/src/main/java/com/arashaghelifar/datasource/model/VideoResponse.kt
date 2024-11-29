package com.arashaghelifar.datasource.model

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("video")
    val video: Video
)


data class Video(
    @SerializedName("video_url")
    val videoUrl: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publish_at")
    val publishAt: String,
    @SerializedName("platforms")
    val platforms: Platforms,
)

data class Platforms(
    @SerializedName("instagram")
    val instagram: Boolean,
    @SerializedName("twitter")
    val twitter: Boolean,
    @SerializedName("linkedin")
    val linkedin: Boolean,
)