package com.example.androidinterview.data

import com.example.androidinterview.data.repository.AuthorRepository
import com.example.androidinterview.data.repository.AuthorRepositoryImpl
import com.example.androidinterview.data.repository.datasource.AuthorDataSource
import com.example.androidinterview.data.repository.datasource.AuthorMockDataSource
import com.example.androidinterview.data.repository.datasource.AuthorRemoteDataSource

object DiUtils {

    fun isMockEnabled(): Boolean {
        return false
    }

    fun provideRepository(): AuthorRepository {
        return AuthorRepositoryImpl()
    }

    fun provideRemoteDataSource(): AuthorDataSource {
        return AuthorRemoteDataSource()
    }

    fun provideMockDataSource(): AuthorMockDataSource {
        return AuthorMockDataSource()
    }

}