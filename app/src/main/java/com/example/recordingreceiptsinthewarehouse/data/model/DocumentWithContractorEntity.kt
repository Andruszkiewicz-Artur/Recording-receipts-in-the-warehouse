package com.example.recordingreceiptsinthewarehouse.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractor

data class DocumentWithContractorEntity(
    @Embedded val document: DocumentEntity,
    @Relation(
        parentColumn = "contractorId",
        entityColumn = "contractorId"
    )
    val contractor: ContractorEntity
) {
    fun toDomain() = DocumentWithContractor(document.toDomain(), contractor.toDomain())
}
