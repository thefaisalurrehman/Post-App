package com.project.postapp.data.repository.remote.datasourceimpl

import com.project.postapp.data.model.PostDTO
import com.project.postapp.data.repository.remote.datasource.PostListRemoteDataSource
import com.project.postapp.data.util.APIConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get


class PostListRemoteDataSourceImpl(
    private val httpClient: HttpClient) : PostListRemoteDataSource {

    override suspend fun getPostListFromRemote(url: String): List<PostDTO> {
        return httpClient.get("${APIConstants.BASE_URL}${url}") {
        }.body<List<PostDTO>>()
    }

}
