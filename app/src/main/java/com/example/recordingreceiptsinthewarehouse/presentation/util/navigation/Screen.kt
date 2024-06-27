package com.example.recordingreceiptsinthewarehouse.presentation.util.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data class AddEditContractor(
        val id: Long
    ): Screen()

    @Serializable
    data class AddEditDocument(
        val id: Long
    ): Screen()

    @Serializable
    data object DocumentsList: Screen()

    @Serializable
    data class ContractorList(
        val idDocument: Long = -1
    ): Screen()

    @Serializable
    data class DocumentDetails(
        val id: Long
    ): Screen()

    @Serializable
    data class AddEditDocumentPosition(
        val idDocument: Long,
        val idDocumentPosition: Long
    ): Screen()
}