package com.project.postapp.presentation.feature.psotlist

import com.project.postapp.domain.entity.Post

data class PostUiState(
    val isLoading:Boolean,
    val posts:List<Post>,
    val error:String?
){
    companion object{

        fun initial():PostUiState = PostUiState(
            isLoading = true,
            posts = emptyList(),
            error = null
        )
    }
}
