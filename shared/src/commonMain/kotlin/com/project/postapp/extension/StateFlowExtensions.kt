package com.project.postapp.extension

import com.project.postapp.presentation.base.KmmStateFlow
import kotlinx.coroutines.flow.StateFlow

internal fun <T> StateFlow<T>.asKmmStateFlow() = KmmStateFlow(this)
