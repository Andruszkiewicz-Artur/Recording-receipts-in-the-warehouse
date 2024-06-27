package com.example.recordingreceiptsinthewarehouse.data.repository

import com.example.recordingreceiptsinthewarehouse.data.local.ContractorDao
import com.example.recordingreceiptsinthewarehouse.data.local.DocumentDao
import com.example.recordingreceiptsinthewarehouse.data.local.DocumentPositionDao
import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorAndPositionsEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentWithContractorEntity
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.model.Document
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentPosition
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractor
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractorAndPositions
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DocumentRepositoryImpl(
    private val documentDao: DocumentDao,
    private val contractorDao: ContractorDao,
    private val documentPositionDao: DocumentPositionDao
): DocumentRepository {
    override suspend fun upsertDocument(document: Document) = documentDao.upsertDocument(document.toEntity())

    override suspend fun deleteDocument(document: Document) = documentDao.deleteDocument(document.toEntity())

    override suspend fun getAllDocuments(): Flow<List<Document>> = documentDao.getAllDocuments().map { it.map { it.toDomain() } }

    override suspend fun getDocumentWithContractorAndPositionsById(documentId: Long): Flow<DocumentWithContractorAndPositions> = documentDao.getDocumentWithContractorAndPositionsById(documentId).map { it.toDomain() }

    override suspend fun getDocumentWithContractorById(documentId: Long): Flow<DocumentWithContractor> = documentDao.getDocumentWithContractorById(documentId).map { it.toDomain() }

    override suspend fun getDocumentById(documentId: Long): Document = documentDao.getDocumentById(documentId).toDomain()

    override suspend fun getAllDocumentWithContractor(): Flow<List<DocumentWithContractor>> = documentDao.getAllDocumentWithContractor().map { it.map { it.toDomain() } }

    override suspend fun upsertContractor(contractor: Contractor) = contractorDao.upsertContractor(contractor.toEntity())

    override suspend fun deleteContractor(contractor: Contractor) = contractorDao.deleteContractor(contractor.toEntity())

    override suspend fun getAllContractors(): Flow<List<Contractor>> = contractorDao.getAllContractors().map { it.map { it.toDomain() } }

    override suspend fun upsertDocumentPosition(documentPosition: DocumentPosition) = documentPositionDao.upsertDocumentPosition(documentPosition.toEntity())

    override suspend fun deleteDocumentPosition(documentPosition: DocumentPosition) = documentPositionDao.deleteDocumentPosition(documentPosition.toEntity())

    override suspend fun getContractorById(idContractor: Long): Contractor? = contractorDao.getContractorById(idContractor)?.toDomain()

    override suspend fun getDocumentPositionById(documentPositionId: Long): DocumentPosition = documentPositionDao.getDocumentWithContractorById(documentPositionId)
}