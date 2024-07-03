package com.project.postapp.domain.usecases

import com.project.postapp.domain.entity.Post
import com.project.postapp.domain.repository.PostListRepository
import kotlinx.coroutines.flow.Flow

class PostListUseCase(private val postListRepository: PostListRepository) {
    fun getPostList(url: String): Flow<List<Post>> {
        return postListRepository.getPostList(url)
    }
 }