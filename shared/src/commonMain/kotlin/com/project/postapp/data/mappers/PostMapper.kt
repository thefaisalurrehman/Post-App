package com.project.postapp.data.mappers

import com.project.postapp.data.model.PostDTO
import com.project.postapp.domain.entity.Post


class PostDataMapper {

    fun mapPostResponse(response: PostDTO) = Post(
        id = response.id,
        title = response.title,
        body = response.body,
        userId = response.userId
    )
}

fun asDomainPostEntity(
    id: Long,
    title: String,
    body: String,
    userId: Long
): Post = Post(id.toInt(), title, body, userId.toInt())
