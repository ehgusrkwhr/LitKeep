package com.dodo.litkeep.domain.model


data class Book(
    val title: String,
    val items: List<BookItem>
)

data class BookItem(
    val title: String,
    val author: String,
    val pubDate: String,
    val priceSales: Int,
    val cover: String,
    val publisher: String,
    val customerReviewRank: Int
)