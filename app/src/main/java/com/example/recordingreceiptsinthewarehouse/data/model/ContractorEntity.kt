package com.example.recordingreceiptsinthewarehouse.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor

@Entity(tableName = "Contractors")
data class ContractorEntity(
    @PrimaryKey(autoGenerate = true)
    val contractorId: Long?,
    val symbol: String,
    val name: String
) {
    fun toDomain() = Contractor(contractorId, symbol, name)
}
