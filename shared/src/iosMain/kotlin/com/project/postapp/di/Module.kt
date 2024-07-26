package com.project.postapp.di

import com.project.postapp.data.factory.DriverFactory
import com.project.postapp.presentation.feature.psotlist.PostListViewModel
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DriverFactory() }

    single {
        Darwin.create()
    }

    single { PostListViewModel(get()) }
}

object ViewModelProvider : KoinComponent {
    fun getPostListViewModel() = get<PostListViewModel>()
}
