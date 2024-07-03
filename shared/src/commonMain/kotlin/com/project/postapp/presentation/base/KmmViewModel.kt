package com.project.postapp.presentation.base

import kotlinx.coroutines.CoroutineScope

expect abstract class KmmViewModel() {
    protected var viewModelScope: CoroutineScope
    abstract fun handleException(e: Throwable)
}