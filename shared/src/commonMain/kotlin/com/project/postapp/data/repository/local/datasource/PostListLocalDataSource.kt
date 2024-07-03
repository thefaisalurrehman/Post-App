package com.project.postapp.data.repository.local.datasource

import com.project.postapp.domain.entity.Post

interface PostListLocalDataSource {

    fun insertPostListToDB(posts: List<Post>)

    fun deletePostListFromDB()

    fun getPostListFromLocal(): List<Post>

}