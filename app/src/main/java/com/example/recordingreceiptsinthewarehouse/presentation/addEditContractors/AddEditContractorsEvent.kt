package com.example.recordingreceiptsinthewarehouse.presentation.addEditContractors

sealed class AddEditContractorsEvent {

    data class EnteredSymbol(val value: String): AddEditContractorsEvent()
    data class EnteredName(val value: String): AddEditContractorsEvent()
    data class SetUpView(val id: Long): AddEditContractorsEvent()

    data object SaveContractor: AddEditContractorsEvent()
}