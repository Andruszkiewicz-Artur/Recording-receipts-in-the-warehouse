package com.example.recordingreceiptsinthewarehouse.domain.repository

import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorAndPositionsEntity
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractorAndPositions
import kotlinx.coroutines.flow.Flow
import com.example.recordingreceiptsinthewarehouse.domain.model.Document as Document

interface DocumentRepository {

    suspend fun upsertDocument(document: Document)

    suspend fun deleteDocument(document: Document)

    suspend fun getAllDocuments(): Flow<List<Document>>

    suspend fun getDocumentById(documentId: Long): DocumentWithContractorAndPositions

    suspend fun upsertContractor(contractor: Contractor)

    suspend fun deleteContractor(contractor: Contractor)

    suspend fun getAllContractors(): Flow<List<Contractor>>

    suspend fun upsertDocumentPosition(document: Document)

    suspend fun deleteDocumentPosition(document: Document)

    suspend fun getContractorById(idContractor: Long): Contractor?
}