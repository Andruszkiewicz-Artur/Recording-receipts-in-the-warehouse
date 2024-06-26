package com.example.recordingreceiptsinthewarehouse.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recordingreceiptsinthewarehouse.domain.model.Document

@Entity(tableName = "Documents")
data class DocumentEntity(
    @PrimaryKey(autoGenerate = true)
    val documentId: Long?,
    val data: Long,
    val symbol: String,
    val contractorId: Int,
) {
    fun toDomain() = Document(documentId, data, symbol, contractorId)
}
