package com.example.recordingreceiptsinthewarehouse.domain.repository

import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorAndPositionsEntity
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentPosition
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractor
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractorAndPositions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.recordingreceiptsinthewarehouse.domain.model.Document as Document

interface DocumentRepository {

    suspend fun upsertDocument(document: Document)

    suspend fun deleteDocument(document: Document)

    suspend fun getAllDocuments(): Flow<List<Document>>

    suspend fun getDocumentWithContractorAndPositionsById(documentId: Long): Flow<DocumentWithContractorAndPositions>

    suspend fun getDocumentWithContractorById(documentId: Long): Flow<DocumentWithContractor>

    suspend fun getDocumentById(documentId: Long): Document

    suspend fun getAllDocumentWithContractor(): Flow<List<DocumentWithContractor>>

    suspend fun upsertContractor(contractor: Contractor)

    suspend fun deleteContractor(contractor: Contractor)

    suspend fun getAllContractors(): Flow<List<Contractor>>

    suspend fun upsertDocumentPosition(documentPosition: DocumentPosition)

    suspend fun deleteDocumentPosition(documentPosition: DocumentPosition)

    suspend fun getContractorById(idContractor: Long): Contractor?

    suspend fun getDocumentPositionById(documentPositionId: Long): DocumentPosition
}