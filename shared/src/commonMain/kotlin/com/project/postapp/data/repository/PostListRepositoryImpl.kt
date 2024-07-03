package com.project.postapp.data.repository

import com.project.postapp.data.mappers.PostDataMapper
import com.project.postapp.data.repository.local.datasource.PostListLocalDataSource
import com.project.postapp.data.repository.remote.datasource.PostListRemoteDataSource
import com.project.postapp.domain.entity.Post
import com.project.postapp.domain.repository.PostListRepository
import kotlinx.coroutines.flow.Flow

class PostListRepositoryImpl(
    private val postListRemoteDataSource: PostListRemoteDataSource,
    private val postListLocalDataSource: PostListLocalDataSource,
    private val dataMapper: PostDataMapper
) : PostListRepository {

    override fun getPostList(url: String): Flow<List<Post>> =
        singleSourceOfTruth(
            getLocalData = { getPostListFromLocal() },
            getRemoteData = {
                postListRemoteDataSource.getPostListFromRemote(url).map {
                    dataMapper.mapPostResponse(it)
                }
            },
            saveDataToLocal = { postList ->
                postListLocalDataSource.deletePostListFromDB()
                postListLocalDataSource.insertPostListToDB(postList)
            }
        )

    private fun getPostListFromLocal(): List<Post> {
        var postList: List<Post> = emptyList()
        if (postList.isEmpty()) {
            postList = postListLocalDataSource.getPostListFromLocal()
        }
        return postList
    }
}