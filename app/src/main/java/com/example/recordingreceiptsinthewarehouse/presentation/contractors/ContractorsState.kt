package com.example.recordingreceiptsinthewarehouse.presentation.contractors

import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor

data class ContractorsState(
    val contractors: List<Contractor> = listOf(),
    val documentId: Long?  = null
)
