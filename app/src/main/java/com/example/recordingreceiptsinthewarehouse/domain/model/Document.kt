package com.example.recordingreceiptsinthewarehouse.domain.model

import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity

data class Document(
    val documentId: Long?,
    val data: Long,
    val symbol: String,
    val contractorId: Long?,
) {
    fun toEntity() = DocumentEntity(documentId, data, symbol, contractorId)
}
