package com.dodo.litkeep.domain.repository

import com.dodo.litkeep.domain.DataResource
import com.dodo.litkeep.domain.model.Book
import com.dodo.litkeep.domain.model.DataResult
import kotlinx.coroutines.flow.Flow

interface BookshelfRepository {
    suspend fun searchBooks(query: String): Flow<DataResource<List<Book>>>
    suspend fun updateMyBook()
    suspend fun deleteMyBook(bookId: Long)
}
