package com.example.recordingreceiptsinthewarehouse.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentPositionEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorEntity
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentPosition

@Dao
interface DocumentPositionDao {

    @Upsert
    suspend fun upsertDocumentPosition(documentPositionEntity: DocumentPositionEntity)

    @Delete
    suspend fun deleteDocumentPosition(documentPositionEntity: DocumentPositionEntity)

    @Query("SELECT * FROM documentsposition WHERE positionId = :positionId")
    suspend fun getDocumentWithContractorById(positionId: Long): DocumentPosition
}