package com.example.recordingreceiptsinthewarehouse.presentation.contractors

import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor

sealed class ContractorEvent {

    data class DeleteContractor(val contractor: Contractor): ContractorEvent()
    data class SetUpContractorInDocument(val idDocument: Long, val contractor: Contractor): ContractorEvent()

}