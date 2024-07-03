package com.project.postapp.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

actual abstract class KmmViewModel : ViewModel() {

    protected actual var viewModelScope: CoroutineScope = CoroutineScope(SupervisorJob())
    actual abstract fun handleException(e: Throwable)

}