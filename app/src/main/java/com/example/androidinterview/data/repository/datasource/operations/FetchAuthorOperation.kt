package com.example.androidinterview.data.repository.datasource.operations

import com.example.androidinterview.data.model.AuthorResponse
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class FetchAuthorOperation {
    suspend fun retrofitCall(): Response<AuthorResponse> {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.addInterceptor(OkHttpProfilerInterceptor())
        okhttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .client(okhttpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(FetchAuthorInterface::class.java)
        return service.getAuthor()
    }
}