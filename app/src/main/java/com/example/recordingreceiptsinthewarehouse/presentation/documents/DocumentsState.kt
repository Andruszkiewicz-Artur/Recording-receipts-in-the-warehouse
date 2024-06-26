package com.example.recordingreceiptsinthewarehouse.presentation.documents

import com.example.recordingreceiptsinthewarehouse.domain.model.Document
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentWithContractor

data class DocumentsState(
    val documentsWithContractors: List<DocumentWithContractor> = listOf()
)
