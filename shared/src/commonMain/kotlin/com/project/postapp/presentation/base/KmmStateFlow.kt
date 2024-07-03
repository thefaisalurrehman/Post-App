package com.project.postapp.presentation.base

import kotlinx.coroutines.flow.StateFlow

expect class KmmStateFlow<T>(source: StateFlow<T>) : StateFlow<T>