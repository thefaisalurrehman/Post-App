package com.project.postapp.presentation.feature.psotlist

import com.project.postapp.presentation.base.KmmViewModel
import com.project.postapp.extension.asKmmStateFlow
import com.project.postapp.data.util.APIConstants
import com.project.postapp.domain.usecases.PostListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("PostListViewModelDelegate")
class PostListViewModel(private val postListUseCase: PostListUseCase) : KmmViewModel() {

    override fun handleException(e: Throwable) {
        println("handleException ${e.message}")
        _uiState.update { it.copy(error = e.message ?: "Unknown Error") }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, e -> handleException(e) }

    private val _uiState =
        MutableStateFlow(PostUiState.initial())
    val uiState = _uiState.asKmmStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch(exceptionHandler) {
            try {
                postListUseCase.getPostList(APIConstants.POSTS).collect { movies ->
                    _uiState.update {
                        it.copy(posts = movies, isLoading = false)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update {
                    it.copy(error = e.message, isLoading = false)
                }
            }
        }
    }

//    fun onCleared() {
//        viewModelScope.cancel()
//    }
}