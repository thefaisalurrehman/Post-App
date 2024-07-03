package com.project.postapp.di

import com.project.postapp.data.factory.DriverFactory
import com.project.postapp.presentation.feature.psotlist.PostListViewModel
import io.ktor.client.engine.android.Android
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DriverFactory(get()) }

    single {
        Android.create()
    }

    viewModel {
        PostListViewModel(get())
    }
}