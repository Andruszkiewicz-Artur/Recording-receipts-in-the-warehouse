package com.example.recordingreceiptsinthewarehouse.domain.repository

import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorAndPositionsEntity
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractorAndPositions
import kotlinx.coroutines.flow.Flow
import com.example.recordingreceiptsinthewarehouse.domain.model.Document as Document

interface DocumentRepository {

    fun upsertDocument(document: Document)

    fun deleteDocument(document: Document)

    fun getAllDocuments(): Flow<List<Document>>

    fun getDocumentById(documentId: Long): DocumentWithContractorAndPositions

    fun upsertContractor(contractor: Contractor)

    fun deleteContractor(contractor: Contractor)

    fun getAllContractors(): Flow<List<Contractor>>

    fun upsertDocumentPosition(document: Document)

    fun deleteDocumentPosition(document: Document)
}