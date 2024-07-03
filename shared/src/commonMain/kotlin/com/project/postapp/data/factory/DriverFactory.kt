package com.project.postapp.data.factory


import app.cash.sqldelight.db.SqlDriver


expect class DriverFactory {
    fun createDriver(): SqlDriver
}