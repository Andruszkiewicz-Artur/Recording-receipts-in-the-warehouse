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

    @Query("SELECT * FROM documents WHERE documentId = :documentId")
    suspend fun getDocumentById(documentId: Long): DocumentEntity

    @Transaction
    @Query("SELECT * FROM documents WHERE documentId = :documentId")
    fun getDocumentWithContractorAndPositionsById(documentId: Long): Flow<DocumentWithContractorAndPositionsEntity>

    @Transaction
    @Query("SELECT * FROM documents WHERE documentId = :documentId")
    fun getDocumentWithContractorById(documentId: Long): Flow<DocumentWithContractorEntity>

    @Transaction
    @Query("SELECT * FROM documents")
    fun getAllDocumentWithContractor(): Flow<List<DocumentWithContractorEntity>>

    @Query("UPDATE Documents SET contractorId = NULL WHERE contractorId = :contractorId")
    suspend fun updateDocumentsContractorId(contractorId: Long)

}