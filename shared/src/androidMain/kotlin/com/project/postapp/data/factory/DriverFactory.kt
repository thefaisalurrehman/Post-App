package com.project.postapp.data.factory

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.project.postapp.database.PostDatabase


actual class DriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PostDatabase.Schema, context, "PostDatabase.db")
    }
}
