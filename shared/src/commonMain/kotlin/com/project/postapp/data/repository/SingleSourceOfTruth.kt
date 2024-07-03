package com.project.postapp.data.repository

import com.project.postapp.domain.entity.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal fun singleSourceOfTruth (
    getLocalData: suspend () -> List<Post>,
    getRemoteData: suspend () -> List<Post>,
    saveDataToLocal: suspend (List<Post>) -> Unit,
): Flow<List<Post>> = flow {
    val localData =  getLocalData()
    if (localData.isNotEmpty()) {
        emit(localData)
    } else {
        val remoteData = getRemoteData()
        if (remoteData.isNotEmpty()) {
            saveDataToLocal(remoteData)
            val localDataUpdated = getLocalData()
            emit(localDataUpdated)
        }
    }
}