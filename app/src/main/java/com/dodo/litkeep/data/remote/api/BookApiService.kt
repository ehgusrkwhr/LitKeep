package com.dodo.litkeep.data.remote.api

import com.dodo.litkeep.data.remote.model.BookResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface BookApiService {

    @GET("ItemSearch.aspx")
    suspend fun searchBooks(
        @QueryMap params: Map<String, String>
    ): Response<List<BookResponse>>

//    @GET("ItemSearch.aspx")
//    suspend fun searchBooks(
//        @Query("ttbkey") ttbKey: String,
//        @Query("Query") query: String,
//        @Query("QueryType") queryType: String = "Title",
//        @Query("MaxResults") maxResults: Int = 10,
//        @Query("start") start: Int = 1,
//        @Query("SearchTarget") searchTarget: String = "Book",
//        @Query("output") output: String = "xml",
//        @Query("Version") version: String = "20131101"
//    ): Response<AladinResponse>
}