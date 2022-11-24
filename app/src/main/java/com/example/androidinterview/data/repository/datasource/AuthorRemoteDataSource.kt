package com.example.androidinterview.data.repository.datasource

import com.example.androidinterview.data.model.Author
import com.example.androidinterview.data.model.AuthorResponse
import com.example.androidinterview.data.model.OperationResult
import com.example.androidinterview.data.repository.datasource.operations.FetchAuthorOperation
import com.google.gson.Gson

class AuthorRemoteDataSource: AuthorDataSource {
    override suspend fun getAuthors(): OperationResult<List<Author>> {
        val result = FetchAuthorOperation().retrofitCall()
        val operationResult = if (result.isSuccessful) {
            OperationResult.success(result.body()?.authors)
        } else {
            try {
                val errorResponse = Gson().fromJson(result.errorBody()?.charStream(), AuthorResponse::class.java)
                OperationResult.error(errorResponse.authors, result.message())
            } catch (exception: Exception) {
                OperationResult.error(listOf(), exception.message)
            }
        }
        return operationResult
    }
}