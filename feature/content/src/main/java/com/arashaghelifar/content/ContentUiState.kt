package com.arashaghelifar.content

import androidx.annotation.DrawableRes
import com.arashaghelifar.repository.model.ContentState
import com.arashaghelifar.repository.model.PlatformsEnum

data class ContentUiState(
    val title: String = "Title Loading ...",
    val description: String = "Description Loading ...",
    val thumbnailUrl: String = "",
    val videoUrl: String = "",
    val platforms: List<PlatformsUiEnum> = listOf(),
    val dateString: String = "Date Loading ...",
    val timeString: String = "Time Loading ...",
)

enum class PlatformsUiEnum(@DrawableRes val icon: Int) {
    INSTAGRAM(icon = R.drawable.svg_social_insta_filled),
    LINKEDIN(icon = R.drawable.svg_social_linkedin_filled),
    TWITTER(icon = R.drawable.svg_social_twitter_filled)
}


fun ContentState.mapToUiState() = ContentUiState(
    title = title,
    description = description,
    thumbnailUrl = thumbnailUrl,
    videoUrl = videoUrl,
    platforms = platforms.map {
        when (it) {
            PlatformsEnum.INSTAGRAM -> PlatformsUiEnum.INSTAGRAM
            PlatformsEnum.LINKEDIN -> PlatformsUiEnum.LINKEDIN
            PlatformsEnum.TWITTER -> PlatformsUiEnum.TWITTER
        }
    },
    dateString = date,
    timeString = time
)