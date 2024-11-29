package com.arashaghelifar.repository.model

import com.arashaghelifar.datasource.model.Platforms
import com.arashaghelifar.datasource.model.VideoResponse
import com.arashaghelifar.repository.utils.extractDate
import com.arashaghelifar.repository.utils.extractTime

data class ContentState(
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val videoUrl: String,
    val platforms: List<PlatformsEnum>,
    val time: String,
    val date: String
)

fun VideoResponse.mapToContentState() = ContentState(
    title = video.title,
    description = video.description,
    thumbnailUrl = video.thumbnail,
    videoUrl = video.videoUrl,
    platforms = extractPlatform(video.platforms),
    time = video.publishAt.extractTime(),
    date = video.publishAt.extractDate(),
)

private fun extractPlatform(platform: Platforms): List<PlatformsEnum> {
    val list = mutableListOf<PlatformsEnum>()
    if (platform.instagram) list.add(PlatformsEnum.INSTAGRAM)
    if (platform.linkedin) list.add(PlatformsEnum.LINKEDIN)
    if (platform.twitter) list.add(PlatformsEnum.TWITTER)
    return list
}