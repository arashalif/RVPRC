package com.arashaghelifar.repository.model

import com.arashaghelifar.datasource.model.Platforms
import com.arashaghelifar.datasource.model.VideoResponse

data class ContentState(
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val videoUrl: String,
    val platforms: List<PlatformsEnum>,
    val time: String
)

fun VideoResponse.mapToContentState() = ContentState(
    title = video.title,
    description = video.description,
    thumbnailUrl = video.thumbnail,
    videoUrl = video.videoUrl,
    platforms = extractPlatform(video.platforms),
    time = video.publishAt
)

private fun extractPlatform(platform: Platforms): List<PlatformsEnum> {
    val list = mutableListOf<PlatformsEnum>()
    if (platform.instagram) list.add(PlatformsEnum.INSTAGRAM)
    if (platform.linkedin) list.add(PlatformsEnum.LINKEDIN)
    if (platform.twitter) list.add(PlatformsEnum.TWITTER)
    return list
}