package com.project.postapp.di

import com.project.postapp.data.mappers.PostDataMapper
import com.project.postapp.data.repository.PostListRepositoryImpl
import com.project.postapp.data.repository.local.datasource.PostListLocalDataSource
import com.project.postapp.data.repository.local.datasourceimpl.PostListLocalDataSourceImpl
import com.project.postapp.data.repository.remote.datasource.PostListRemoteDataSource
import com.project.postapp.data.repository.remote.datasourceimpl.PostListRemoteDataSourceImpl
import com.project.postapp.domain.repository.PostListRepository
import com.project.postapp.domain.usecases.PostListUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin() = initKoin {}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules (
            appModule,
            dataSourceModule,
            useCasesModule,
            platformModule()
        )
    }


val dataSourceModule = module {
    single { PostDataMapper() }
    single<PostListRemoteDataSource> { PostListRemoteDataSourceImpl(get()) }
    single<PostListLocalDataSource> { PostListLocalDataSourceImpl(get()) }

    single<PostListRepository> { PostListRepositoryImpl(get(), get(), get()) }
}

val useCasesModule: Module = module {
    factory { PostListUseCase(get()) }
}

val appModule = module {
    single { Json { isLenient = true; ignoreUnknownKeys = true } }
    single {
        HttpClient(get()) {
            install(ContentNegotiation) {
                json(get())
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
}