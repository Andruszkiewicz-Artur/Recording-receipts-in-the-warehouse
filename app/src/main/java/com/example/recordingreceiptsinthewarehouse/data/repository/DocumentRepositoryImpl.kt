package com.example.recordingreceiptsinthewarehouse.data.repository

import com.example.recordingreceiptsinthewarehouse.data.local.ContractorDao
import com.example.recordingreceiptsinthewarehouse.data.local.DocumentDao
import com.example.recordingreceiptsinthewarehouse.data.local.DocumentPositionDao
import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorAndPositionsEntity
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.model.Document
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractorAndPositions
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DocumentRepositoryImpl(
    private val documentDao: DocumentDao,
    private val contractorDao: ContractorDao,
    private val documentPositionDao: DocumentPositionDao
): DocumentRepository {
    override fun upsertDocument(document: Document) = documentDao.upsertDocument(document.toEntity())

    override fun deleteDocument(document: Document) = documentDao.deleteDocument(document.toEntity())

    override fun getAllDocuments(): Flow<List<Document>> = documentDao.getAllDocuments().map { it.map { it.toDomain() } }

    override fun getDocumentById(documentId: Long): DocumentWithContractorAndPositions = documentDao.getDocumentById(documentId).toDomain()

    override fun upsertContractor(contractor: Contractor) = contractorDao.upsertContractor(contractor.toEntity())

    override fun deleteContractor(contractor: Contractor) = contractorDao.deleteContractor(contractor.toEntity())

    override fun getAllContractors(): Flow<List<Contractor>> = contractorDao.getAllContractors().map { it.map { it.toDomain() } }

    override fun upsertDocumentPosition(document: Document) = documentPositionDao.upsertDocumentPosition(document.toEntity())

    override fun deleteDocumentPosition(document: Document) = documentPositionDao.deleteDocumentPosition(document.toEntity())
}