package com.example.recordingreceiptsinthewarehouse.domain.model

import com.example.recordingreceiptsinthewarehouse.data.model.DocumentPositionEntity

data class DocumentPosition(
    val positionId: Long?,
    val documentOwnId: Long,
    val name: String,
    val count: Float,
    val unitOfMeasure: String
) {
    fun toEntity() = DocumentPositionEntity(positionId, documentOwnId, name, count, unitOfMeasure)
}
