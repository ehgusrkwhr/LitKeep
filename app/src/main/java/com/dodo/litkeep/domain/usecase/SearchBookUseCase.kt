package com.dodo.litkeep.domain.usecase

import com.dodo.litkeep.domain.DataResource
import com.dodo.litkeep.domain.model.Book
import com.dodo.litkeep.domain.repository.BookshelfRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchBookUseCase @Inject constructor(
    private val bookshelfRepository: BookshelfRepository
) {
    suspend operator fun invoke(query : String) : Flow<DataResource<List<Book>>> {
        return bookshelfRepository.searchBooks(query)
    }
}