package com.dodo.litkeep.data.datasource

import com.dodo.litkeep.data.model.BookData
import com.dodo.litkeep.data.remote.model.BookResponse

interface BookRemoteDataSource {
    suspend fun searchBooks(query: String): List<BookData>
    suspend fun updateBook(book: BookResponse)
    suspend fun deleteBook(bookId: Long)
}