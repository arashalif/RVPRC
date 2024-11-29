package com.arashaghelifar.repository

import com.arashaghelifar.repository.model.ContentState
import com.arashaghelifar.repository.model.EditState
import com.arashaghelifar.repository.model.ResultState
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun fetchVideo(): Flow<ResultState<ContentState>>
    suspend fun updateVideo(title: String, description: String): Flow<ResultState<EditState>>
}