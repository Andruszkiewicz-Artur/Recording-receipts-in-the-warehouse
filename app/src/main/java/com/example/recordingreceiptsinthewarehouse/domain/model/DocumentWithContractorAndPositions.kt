package com.example.recordingreceiptsinthewarehouse.domain.model

data class DocumentWithContractorAndPositions(
    val document: Document,
    val contractor: Contractor?,
    val position: List<DocumentPosition>
)
