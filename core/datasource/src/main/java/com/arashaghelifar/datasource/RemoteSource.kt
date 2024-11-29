package com.arashaghelifar.datasource

import com.arashaghelifar.datasource.model.RVResponse
import com.arashaghelifar.datasource.model.VideoResponse
import com.arashaghelifar.datasource.model.VideoUpdateRequest
import kotlinx.coroutines.flow.Flow

interface RemoteSource {
    suspend fun fetchVideo(): Flow<RVResponse<VideoResponse>>
    suspend fun putVideo(request: VideoUpdateRequest): Flow<RVResponse<Any?>>
}