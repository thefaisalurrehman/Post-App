package com.project.postapp.presentation.feature.psotlist

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: String?) : Result<Nothing>
    data object Loading : Result<Nothing>
    data object Idle : Result<Nothing>
}