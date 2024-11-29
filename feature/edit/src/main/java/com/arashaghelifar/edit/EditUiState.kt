package com.arashaghelifar.edit

import com.arashaghelifar.repository.model.ContentState


data class EditUiState(
    val title: String = "Title Loading ...",
    val description: String = "Description Loading ...",
)

fun ContentState.mapToUiState() = EditUiState(
    title = title,
    description = description,

)