package com.project.postapp.presentation.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

actual abstract class KmmViewModel {
    protected actual var viewModelScope: CoroutineScope =
        CoroutineScope(SupervisorJob())

    fun onCleared() {
        viewModelScope.cancel()
    }

    actual abstract fun handleException(e: Throwable)
}