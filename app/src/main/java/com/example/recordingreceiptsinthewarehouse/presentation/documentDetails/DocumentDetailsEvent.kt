package com.example.recordingreceiptsinthewarehouse.presentation.documentDetails

sealed class DocumentDetailsEvent {

    data class SetUpView(val id: Long): DocumentDetailsEvent()

}