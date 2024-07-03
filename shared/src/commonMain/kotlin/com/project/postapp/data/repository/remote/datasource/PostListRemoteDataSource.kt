package com.project.postapp.data.repository.remote.datasource

import com.project.postapp.data.model.PostDTO

interface PostListRemoteDataSource {

    suspend fun getPostListFromRemote(url: String): List<PostDTO>

}