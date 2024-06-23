package com.example.recordingreceiptsinthewarehouse.presentation.util.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
    data object Home: Screen()

    @Serializable
    data class AddEditContractor(
        val id: Int
    ): Screen()

    @Serializable
    data class AddEditDocument(
        val symbol: String
    ): Screen()

    @Serializable
    data object DocumentsList: Screen()

    @Serializable
    data object DocumentsContractor: Screen()

    @Serializable
    data class DocumentPosition(
        val id: Int
    ): Screen()

    @Serializable
    data class AddEditDocumentPosition(
        val id: Int
    ): Screen()
}