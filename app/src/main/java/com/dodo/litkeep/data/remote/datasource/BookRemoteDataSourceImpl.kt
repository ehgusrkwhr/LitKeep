package com.dodo.litkeep.data.remote.datasource

import com.dodo.litkeep.data.datasource.BookRemoteDataSource
import com.dodo.litkeep.data.model.BookData
import com.dodo.litkeep.data.remote.ApiResult
import com.dodo.litkeep.data.remote.api.BookApiService
import com.dodo.litkeep.data.remote.handleApiResponse
import com.dodo.litkeep.data.remote.model.BookResponse
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(
    private val bookService: BookApiService,
) : BookRemoteDataSource {
    override suspend fun searchBooks(query: String): List<BookData> {
        val params = mapOf(
            "ttbkey" to TTB_KEY,  // 알라딘 API 키
            "Query" to query,     // 검색어
            "QueryType" to "Title",
            "MaxResults" to "10",
            "start" to "1",
            "SearchTarget" to "Book",
            "output" to "xml",
            "Version" to "20131101"
        )

        return when (val result = bookService.searchBooks(params).handleApiResponse()) {
            is ApiResult.Success -> {
                result.data.map { it.toData() }
            }

            is ApiResult.Error -> {
                println("Error: ${result.message}")
                emptyList()
            }

        }
    }

    override suspend fun updateBook(book: BookResponse) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBook(bookId: Long) {
        TODO("Not yet implemented")
    }

    companion object {
        const val TTB_KEY = "ttbehgus46881653001"
    }
}

