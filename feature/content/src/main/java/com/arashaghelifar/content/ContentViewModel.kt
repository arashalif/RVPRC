package com.arashaghelifar.content

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arashaghelifar.repository.Repository
import com.arashaghelifar.repository.model.ResultState
import com.arashaghelifar.repository.model.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _contentState = mutableStateOf<ResultState<ContentUiState>>(ResultState.Loading)
    val contentState: State<ResultState<ContentUiState>> = _contentState

    init {
        viewModelScope.launch {
            repository.fetchVideo().collect { content->
                _contentState.value = content.map {
                    it.mapToUiState()
                }
            }
        }
    }


}