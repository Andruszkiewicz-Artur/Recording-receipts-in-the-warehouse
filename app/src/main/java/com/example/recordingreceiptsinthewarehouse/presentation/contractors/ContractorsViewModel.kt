package com.example.recordingreceiptsinthewarehouse.presentation.contractors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import com.example.recordingreceiptsinthewarehouse.presentation.documents.DocumentsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContractorsViewModel @Inject constructor (
    private val repository: DocumentRepository,
): ViewModel() {

    private val _state = MutableStateFlow(ContractorsState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllContractors().collectLatest { contractors ->
                _state.update { it.copy(
                    contractors = contractors
                ) }
            }
        }
    }

    fun removeContractor(contractor: Contractor) {
        viewModelScope.launch {
            repository.deleteContractor(contractor)
        }
    }
}