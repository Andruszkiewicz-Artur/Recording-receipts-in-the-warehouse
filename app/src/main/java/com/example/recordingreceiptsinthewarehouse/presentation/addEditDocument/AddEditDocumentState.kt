package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument

import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.model.Document
import java.util.Date

data class AddEditDocumentState(
    val document: Document = Document(
        documentId = null,
        data = Date().time,
        symbol = "",
        contractorId = null
    ),
    val contractor: Contractor? = null
)
