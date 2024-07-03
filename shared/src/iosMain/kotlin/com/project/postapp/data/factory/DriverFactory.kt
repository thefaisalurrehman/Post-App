package com.project.postapp.data.factory

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.project.postapp.database.PostDatabase

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PostDatabase.Schema,"PostDatabase.db")
    }
}
