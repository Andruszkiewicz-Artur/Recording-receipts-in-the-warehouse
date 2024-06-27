package com.example.recordingreceiptsinthewarehouse.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorAndPositionsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DocumentDao {

    @Upsert
    suspend fun upsertDocument(documentEntity: DocumentEntity)

    @Delete
    suspend fun deleteDocument(documentEntity: DocumentEntity)

    @Query("SELECT * FROM documents ORDER BY data ASC")
    fun getAllDocuments(): Flow<List<DocumentEntity>>

    @Transaction
    @Query("SELECT * FROM documents WHERE documentId = :documentId")
    fun getDocumentWithContractorAndPositionsById(documentId: Long): Flow<DocumentWithContractorAndPositionsEntity>

    @Transaction
    @Query("SELECT * FROM documents WHERE documentId = :documentId")
    suspend fun getDocumentWithContractorById(documentId: Long): DocumentWithContractorEntity

    @Transaction
    @Query("SELECT * FROM documents")
    fun getAllDocumentWithContractor(): Flow<List<DocumentWithContractorEntity>>

}