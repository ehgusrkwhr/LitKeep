package com.dodo.litkeep.data.remote.model

import com.dodo.litkeep.data.datasource.mapper.RemoteMapper
import com.dodo.litkeep.data.model.BookData
import com.dodo.litkeep.data.model.BookDataItem
import com.dodo.litkeep.data.model.SeriesInfoData
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "object", strict = false)
data class BookResponse(
    @field:Element(name = "title")
    val title: String,

    @field:Element(name = "link")
    val link: String,

    @field:Element(name = "logo")
    val logo: String,

    @field:Element(name = "pubDate")
    val pubDate: String,

    @field:Element(name = "totalResults")
    val totalResults: Int,

    @field:Element(name = "startIndex")
    val startIndex: Int,

    @field:Element(name = "itemsPerPage")
    val itemsPerPage: Int,

    @field:Element(name = "query")
    val query: String,

    @field:Element(name = "version")
    val version: String,

    @field:Element(name = "searchCategoryId")
    val searchCategoryId: Int,

    @field:Element(name = "searchCategoryName")
    val searchCategoryName: String,

    @field:ElementList(name = "item", inline = true)
    val items: List<BookResponseItem>,
) : RemoteMapper<BookData> {
    override fun toData(): BookData {
        return BookData(
            title = this.title,
            link = this.link,
            logo = this.logo,
            pubDate = this.pubDate,
            totalResults = this.totalResults,
            startIndex = this.startIndex,
            itemsPerPage = this.itemsPerPage,
            query = this.query,
            version = this.version,
            searchCategoryId = this.searchCategoryId,
            searchCategoryName = this.searchCategoryName,
            items = this.items.map { it.toData() }
        )
    }
}

@Root(name = "item", strict = false)
data class BookResponseItem(
    @field:Element(name = "title")
    val title: String,

    @field:Element(name = "link")
    val link: String,

    @field:Element(name = "author")
    val author: String,

    @field:Element(name = "pubDate")
    val pubDate: String,

    @field:Element(name = "description", required = false)
    val description: String? = null,

    @field:Element(name = "isbn")
    val isbn: String,

    @field:Element(name = "isbn13")
    val isbn13: String,

    @field:Element(name = "priceSales")
    val priceSales: Int,

    @field:Element(name = "priceStandard")
    val priceStandard: Int,

    @field:Element(name = "mallType")
    val mallType: String,

    @field:Element(name = "stockStatus", required = false)
    val stockStatus: String? = null,

    @field:Element(name = "mileage")
    val mileage: Int,

    @field:Element(name = "cover")
    val cover: String,

    @field:Element(name = "categoryId")
    val categoryId: Int,

    @field:Element(name = "categoryName")
    val categoryName: String,

    @field:Element(name = "publisher")
    val publisher: String,

    @field:Element(name = "salesPoint")
    val salesPoint: Int,

    @field:Element(name = "adult")
    val adult: Boolean,

    @field:Element(name = "fixedPrice")
    val fixedPrice: Boolean,

    @field:Element(name = "customerReviewRank")
    val customerReviewRank: Int,

    @field:Element(name = "seriesInfo", required = false)
    val seriesInfo: SeriesInfo? = null,
) : RemoteMapper<BookDataItem> {
    override fun toData(): BookDataItem {
        return BookDataItem(
            title = this.title,
            link = this.link,
            author = this.author,
            pubDate = this.pubDate,
            description = this.description,
            isbn = this.isbn,
            isbn13 = this.isbn13,
            priceSales = this.priceSales,
            priceStandard = this.priceStandard,
            mallType = this.mallType,
            stockStatus = this.stockStatus,
            mileage = this.mileage,
            cover = this.cover,
            categoryId = this.categoryId,
            categoryName = this.categoryName,
            publisher = this.publisher,
            salesPoint = this.salesPoint,
            adult = this.adult,
            fixedPrice = this.fixedPrice,
            customerReviewRank = this.customerReviewRank,
            seriesInfo = this.seriesInfo?.toData()
        )
    }
}

@Root(name = "seriesInfo", strict = false)
data class SeriesInfo(
    @field:Element(name = "seriesId")
    val seriesId: Int,

    @field:Element(name = "seriesLink")
    val seriesLink: String,

    @field:Element(name = "seriesName")
    val seriesName: String,
) : RemoteMapper<SeriesInfoData> {
    override fun toData(): SeriesInfoData {
        return SeriesInfoData(
            seriesId = this.seriesId,
            seriesLink = this.seriesLink,
            seriesName = this.seriesName
        )
    }
}