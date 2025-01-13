package com.dodo.litkeep.domain.model.mapper

interface DataMapper<DomainModel> {
    fun toDomain() : DomainModel
}