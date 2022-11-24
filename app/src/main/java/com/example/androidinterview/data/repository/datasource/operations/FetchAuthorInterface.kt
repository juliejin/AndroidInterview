package com.example.androidinterview.data.repository.datasource.operations

import com.example.androidinterview.data.model.AuthorResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
/*
https://run.mocky.io/v3/312432a7-41f7-4ec8-9e31-768b2abd8ea0
* */
interface FetchAuthorInterface {
    @GET("v3/312432a7-41f7-4ec8-9e31-768b2abd8ea0")
    suspend fun getAuthor(): Response<AuthorResponse>
}