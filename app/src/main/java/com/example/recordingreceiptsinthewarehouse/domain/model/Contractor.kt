package com.example.recordingreceiptsinthewarehouse.domain.model

import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity

data class Contractor(
    val id: Long,
    val symbol: String,
    val name: String
) {
    fun toEntity() = ContractorEntity(id, symbol, name)
}

