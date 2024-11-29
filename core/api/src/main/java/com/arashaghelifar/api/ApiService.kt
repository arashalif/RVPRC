package com.arashaghelifar.api

import com.arashaghelifar.api.ApiConstants.GET_VIDEO
import com.arashaghelifar.api.ApiConstants.UPDATE_VIDEO
import com.arashaghelifar.datasource.model.RVResponse
import com.arashaghelifar.datasource.model.VideoResponse
import com.arashaghelifar.datasource.model.VideoUpdateRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

internal interface ApiService {

    @GET(GET_VIDEO)
    suspend fun getVideo(): RVResponse<VideoResponse>

    @PUT(UPDATE_VIDEO)
    suspend fun putVideo(@Body request: VideoUpdateRequest): RVResponse<Any?>
}