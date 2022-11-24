package com.example.androidinterview.data.repository.datasource

import com.example.androidinterview.data.model.Author
import com.example.androidinterview.data.model.OperationResult

interface AuthorDataSource {
    suspend fun getAuthors(): OperationResult<List<Author>>
}