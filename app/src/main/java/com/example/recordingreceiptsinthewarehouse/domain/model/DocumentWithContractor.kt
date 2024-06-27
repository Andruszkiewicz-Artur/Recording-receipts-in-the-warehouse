package com.example.recordingreceiptsinthewarehouse.domain.model

data class DocumentWithContractor(
    val document: Document,
    val contractor: Contractor?
)
