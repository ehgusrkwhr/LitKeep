package com.dodo.litkeep.di

import com.dodo.litkeep.data.repository.BookshelfRepositoryImpl
import com.dodo.litkeep.domain.repository.BookshelfRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindBookshelfRepository(bookshelfRepositoryImpl: BookshelfRepositoryImpl): BookshelfRepository

}