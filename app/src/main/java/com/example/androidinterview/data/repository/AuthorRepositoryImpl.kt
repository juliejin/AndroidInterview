package com.example.androidinterview.data.repository

import android.util.Log
import com.example.androidinterview.data.DiUtils
import com.example.androidinterview.data.model.Author

class AuthorRepositoryImpl: AuthorRepository {
    val mockDataSource = DiUtils.provideMockDataSource()
    val remoteDataSource = DiUtils.provideRemoteDataSource()
    override suspend fun getAuthors(): List<Author>? {
        val operationResult = if (DiUtils.isMockEnabled()) mockDataSource.getAuthors()
        else remoteDataSource.getAuthors()
        if (operationResult.isErrorState()) Log.d(AuthorRepositoryImpl::class.java.name, "Error fetching authors: ${operationResult.errorMessage}")
        return operationResult.data
    }
}