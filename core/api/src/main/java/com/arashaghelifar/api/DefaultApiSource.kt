package com.arashaghelifar.api

import com.arashaghelifar.datasource.ApiSource
import com.arashaghelifar.datasource.model.RVResponse
import com.arashaghelifar.datasource.model.VideoResponse
import com.arashaghelifar.datasource.model.VideoUpdateRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class DefaultApiSource @Inject internal constructor(
    private val apiService: ApiService
) : ApiSource {

    override suspend fun fetchVideo(): Flow<RVResponse<VideoResponse>> = flow {
        val response = try {
            apiService.getVideo()
        } catch (e: HttpException) {
            RVResponse<VideoResponse>(status = e.code().toString(), message = e.message(), data = null)
        } catch (e: Exception) {
            RVResponse<VideoResponse>(status = e.message?: "Unknown error", message = e.message?: "Unknown error", data = null)
        }
        emit(response)
    }

    override suspend fun putVideo(request: VideoUpdateRequest): Flow<RVResponse<Any?>> = flow {
        val response = try {
            apiService.putVideo(request)
        } catch (e: HttpException) {
            RVResponse<Any?>(status = e.code().toString(), message = e.message(), data = null)
        } catch (e: Exception) {
            RVResponse<Any?>(status = e.message?: "Unknown error", message = e.message?: "Unknown error", data = null)
        }
        emit(response)
    }
}