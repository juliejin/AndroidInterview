package com.example.androidinterview.data.repository

import com.example.androidinterview.data.model.Author

interface AuthorRepository {
    suspend fun getAuthors(): List<Author>?
}