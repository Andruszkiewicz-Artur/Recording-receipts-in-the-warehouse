package com.example.recordingreceiptsinthewarehouse.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractorAndPositions

data class DocumentWithContractorAndPositionsEntity(
    @Embedded val document: DocumentEntity,
    @Relation(
        parentColumn = "contractorId",
        entityColumn = "contractorId"
    )
    val contractor: ContractorEntity,
    @Relation(
        parentColumn = "documentId",
        entityColumn = "documentOwnId"
    )
    val positions: List<DocumentPositionEntity>
) {
    fun toDomain() = DocumentWithContractorAndPositions(document.toDomain(), contractor.toDomain(), positions.map { it.toDomain() })
}
