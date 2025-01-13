package com.dodo.litkeep.data.datasource.mapper

interface RemoteMapper<DataModel> {
    fun toData() : DataModel
}

interface LocalMapper<DataModel> {
    fun toData() : DataModel
}

interface DataMapper<DomainModel> {
    fun toDomain() : DomainModel
}