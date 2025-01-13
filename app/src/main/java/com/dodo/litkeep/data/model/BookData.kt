package com.dodo.litkeep.data.model

import com.dodo.litkeep.domain.model.Book
import com.dodo.litkeep.domain.model.BookItem
import com.dodo.litkeep.domain.model.mapper.DataMapper

data class BookData(
    val title: String,
    val link: String,
    val logo: String,
    val pubDate: String,
    val totalResults: Int,
    val startIndex: Int,
    val itemsPerPage: Int,
    val query: String,
    val version: String,
    val searchCategoryId: Int,
    val searchCategoryName: String,
    val items: List<BookDataItem>,
) : DataMapper<Book> {
    override fun toDomain(): Book {
        return Book(
            title = this.title,
            items = this.items.map { it.toDomain() }
        )
    }
}

data class BookDataItem(
    val title: String,
    val link: String,
    val author: String,
    val pubDate: String,
    val description: String?,
    val isbn: String,
    val isbn13: String,
    val priceSales: Int,
    val priceStandard: Int,
    val mallType: String,
    val stockStatus: String?,
    val mileage: Int,
    val cover: String,
    val categoryId: Int,
    val categoryName: String,
    val publisher: String,
    val salesPoint: Int,
    val adult: Boolean,
    val fixedPrice: Boolean,
    val customerReviewRank: Int,
    val seriesInfo: SeriesInfoData?,
) : DataMapper<BookItem> {

    override fun toDomain(): BookItem {
        return BookItem(
            title = this.title,
            author = this.author,
            pubDate = this.pubDate,
            priceSales = this.priceSales,
            cover = this.cover,
            publisher = this.publisher,
            customerReviewRank = this.customerReviewRank
        )
    }
}

data class SeriesInfoData(
    val seriesId: Int,
    val seriesLink: String,
    val seriesName: String,
)
