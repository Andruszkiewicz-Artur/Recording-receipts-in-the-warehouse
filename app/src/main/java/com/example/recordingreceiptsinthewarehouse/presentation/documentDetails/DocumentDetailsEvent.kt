package com.example.recordingreceiptsinthewarehouse.presentation.documentDetails

import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentPosition

sealed class DocumentDetailsEvent {

    data class DeletePosition(val documentPosition: DocumentPosition): DocumentDetailsEvent()
    data class SetUpView(val id: Long): DocumentDetailsEvent()

}