package com.project.postapp.data.repository.local.datasourceimpl



import com.project.postapp.data.factory.DriverFactory
import com.project.postapp.data.mappers.asDomainPostEntity
import com.project.postapp.data.repository.local.datasource.PostListLocalDataSource
import com.project.postapp.database.PostDatabase
import com.project.postapp.domain.entity.Post


class PostListLocalDataSourceImpl(
    driverFactory: DriverFactory) : PostListLocalDataSource {

    private val database =
        PostDatabase.invoke(driverFactory.createDriver())
    private val queries = database.postDatabaseQueries

    override fun insertPostListToDB(posts: List<Post>) {
        for (post in posts) {
            queries.transaction {
                queries.insertPostlist(
                    id = post.id.toLong(),
                    title = post.title,
                    body = post.body,
                    userId = post.userId.toLong()
                )
            }
        }
    }

    override fun deletePostListFromDB() {
        queries.removePostlist()
    }

    override fun getPostListFromLocal(): List<Post> {
        return queries.getPostlist(::asDomainPostEntity).executeAsList()
    }
}
