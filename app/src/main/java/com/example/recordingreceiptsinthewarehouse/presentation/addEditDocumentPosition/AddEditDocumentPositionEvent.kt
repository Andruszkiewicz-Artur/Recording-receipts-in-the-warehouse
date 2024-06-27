package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocumentPosition

sealed class AddEditDocumentPositionEvent {

    data class EnteredName(val value: String): AddEditDocumentPositionEvent()
    data class EnteredCount(val value: String): AddEditDocumentPositionEvent()
    data class EnteredUnit(val value: String): AddEditDocumentPositionEvent()
    data class SetUpView(val idDocument: Long, val idDocumentPosition: Long): AddEditDocumentPositionEvent()

    data object Save: AddEditDocumentPositionEvent()

}