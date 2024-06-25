package com.example.recordingreceiptsinthewarehouse.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentPosition

@Entity(tableName = "DocumentsPosition")
data class DocumentPositionEntity(
    @PrimaryKey(autoGenerate = true)
    val positionId: Long,
    val documentOwnId: Long,
    val name: String,
    val count: Float,
    val unitOfMeasure: String
) {
    fun toDomain() = DocumentPosition(positionId, documentOwnId, name, count, unitOfMeasure)
}
