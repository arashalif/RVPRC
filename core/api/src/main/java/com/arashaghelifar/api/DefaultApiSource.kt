package com.arashaghelifar.api

import com.arashaghelifar.datasource.ApiSource
import com.arashaghelifar.datasource.model.RVResponse
import com.arashaghelifar.datasource.model.VideoResponse
import com.arashaghelifar.datasource.model.VideoUpdateRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultApiSource @Inject internal constructor(
    private val apiService: ApiService
) : ApiSource {

    override suspend fun fetchVideo(): Flow<RVResponse<VideoResponse>> = flow {
        emit(apiService.getVideo())
    }

    override suspend fun putVideo(request: VideoUpdateRequest): Flow<RVResponse<Any?>> = flow {
        emit(apiService.putVideo(request))
    }
}