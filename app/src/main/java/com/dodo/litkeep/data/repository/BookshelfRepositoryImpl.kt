package com.dodo.litkeep.data.repository

import com.dodo.litkeep.data.datasource.BookRemoteDataSource
import com.dodo.litkeep.domain.DataResource
import com.dodo.litkeep.domain.model.Book
import com.dodo.litkeep.domain.repository.BookshelfRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookshelfRepositoryImpl @Inject constructor(
    private val bookRemoteDataSource: BookRemoteDataSource,
) : BookshelfRepository {
    override suspend fun searchBooks(query: String): Flow<DataResource<List<Book>>> = flow {
        // 로딩 상태 방출
        emit(DataResource.loading())
        try {
            // 원격 데이터소스 호출
            val remoteBooks = bookRemoteDataSource.searchBooks(query)

            // 데이터 변환: BookData -> Book
            val domainBooks = remoteBooks.map { it.toDomain() }

            // 성공 상태 방출
            emit(DataResource.success(domainBooks))
//                emit(DataResource.success(domainBooks))
        } catch (e: Exception) {
            // 에러 상태 방출
//                emit(DataResource.error(e))
            emit(DataResource.error(e))
        }
    }


    override suspend fun updateMyBook() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMyBook(bookId: Long) {
        TODO("Not yet implemented")
    }

}
