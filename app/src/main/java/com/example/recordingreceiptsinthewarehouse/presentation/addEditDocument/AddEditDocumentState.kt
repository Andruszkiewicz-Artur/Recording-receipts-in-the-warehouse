package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument

import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import java.util.Date

data class AddEditDocumentState(
    val symbol: String = "",
    val contractor: Contractor? = null
)
