package com.example.recordingreceiptsinthewarehouse.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorAndPositionsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DocumentDao {

    @Upsert
    fun upsertDocument(documentEntity: DocumentEntity)

    @Delete
    fun deleteDocument(documentEntity: DocumentEntity)

    @Query("SELECT * FROM documents ORDER BY data ASC")
    fun getAllDocuments(): Flow<List<DocumentEntity>>

    @Transaction
    @Query("SELECT * FROM documents WHERE documentId = :documentId")
    fun getDocumentById(documentId: Long): DocumentWithContractorAndPositionsEntity
}