package com.example.androidinterview.data.repository.datasource

import com.example.androidinterview.data.model.Author
import com.example.androidinterview.data.model.OperationResult

class AuthorMockDataSource: AuthorDataSource {

    override suspend fun getAuthors(): OperationResult<List<Author>> {
        return OperationResult.success(
            listOf(
                Author("name1", "https://picsum.photos/id/237/200/300.jpg"),
                Author("name2", "https://picsum.photos/id/237/200/300.jpg"),
                Author("name3", "https://picsum.photos/id/237/200/300.jpg"),
                Author("name4", "https://picsum.photos/id/237/200/300.jpg"),
                Author("name5", "https://picsum.photos/id/237/200/300.jpg"),
                Author("name6", "https://picsum.photos/id/237/200/300.jpg")
            )
        )
    }

}