package com.project.postapp.domain.repository

import com.project.postapp.domain.entity.Post
import kotlinx.coroutines.flow.Flow

interface PostListRepository {

    fun getPostList(url: String): Flow<List<Post>>
}