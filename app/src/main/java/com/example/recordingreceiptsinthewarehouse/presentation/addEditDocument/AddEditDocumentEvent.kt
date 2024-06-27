package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument

sealed class AddEditDocumentEvent {

    data class EnteredSymbol(val value: String): AddEditDocumentEvent()
    data class SetUpDocument(val id: Long): AddEditDocumentEvent()

    data object SaveDocument: AddEditDocumentEvent()

}