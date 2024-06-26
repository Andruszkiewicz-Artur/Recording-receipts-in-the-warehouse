package com.example.recordingreceiptsinthewarehouse.presentation.documents

import com.example.recordingreceiptsinthewarehouse.domain.model.Document

data class DocumentsState(
    val documents: List<Document> = listOf()
)
