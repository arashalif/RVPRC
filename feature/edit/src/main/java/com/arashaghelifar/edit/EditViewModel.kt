package com.arashaghelifar.edit

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arashaghelifar.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val titleState = mutableStateOf("")
    val descriptionState = mutableStateOf("")

    fun saveChanges() {

        viewModelScope.launch {
            repository.updateVideo(
                title = titleState.value,
                description = descriptionState.value
            )
        }
    }

}