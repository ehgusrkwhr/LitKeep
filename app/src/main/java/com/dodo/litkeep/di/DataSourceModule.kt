package com.dodo.litkeep.di

import com.dodo.litkeep.data.datasource.BookRemoteDataSource
import com.dodo.litkeep.data.remote.datasource.BookRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(bookRemoteDataSourceImpl: BookRemoteDataSourceImpl): BookRemoteDataSource
}