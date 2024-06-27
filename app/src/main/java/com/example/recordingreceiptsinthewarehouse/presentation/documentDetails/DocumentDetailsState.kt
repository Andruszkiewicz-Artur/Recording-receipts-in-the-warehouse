package com.example.recordingreceiptsinthewarehouse.presentation.documentDetails

import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.model.Document
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractorAndPositions

data class DocumentDetailsState(
    val document: DocumentWithContractorAndPositions = DocumentWithContractorAndPositions(
        document = Document(
            documentId = null,
            symbol = "",
            data = 0,
            contractorId = null
        ),
        contractor = null,
        position = listOf()
    )
)
