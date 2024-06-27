package com.example.recordingreceiptsinthewarehouse.presentation.util.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.res.stringResource
import com.example.recordingreceiptsinthewarehouse.R
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
        val isMainPresentation: Boolean = true
    ): Screen()

    @Serializable
    data class DocumentPosition(
        val id: Long
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