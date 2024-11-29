package com.arashaghelifar.repository

import com.arashaghelifar.datasource.ApiSource
import com.arashaghelifar.datasource.model.VideoUpdateRequest
import com.arashaghelifar.repository.model.ContentState
import com.arashaghelifar.repository.model.EditState
import com.arashaghelifar.repository.model.ResultState
import com.arashaghelifar.repository.model.mapToContentState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DefaultRepository @Inject constructor(
    private val apiSource: ApiSource
) : Repository {

    override suspend fun fetchVideo(): Flow<ResultState<ContentState>> {
        return apiSource.fetchVideo().map { data ->
            if (data.status == "success") {
                ResultState.Success(data = data.data?.mapToContentState())
            } else {
                ResultState.Error(data.message)
            }
        }
    }

    override suspend fun updateVideo(
        title: String,
        description: String
    ): Flow<ResultState<EditState>> {
        return apiSource.putVideo(
            request = VideoUpdateRequest(
                title = title,
                description = description
            )
        ).map { data ->
            if (data.status == "success") {
                ResultState.Success(
                    data = EditState(
                        title = title,
                        description = description
                    )
                )
            } else {
                ResultState.Error(data.message)
            }
        }
    }
}