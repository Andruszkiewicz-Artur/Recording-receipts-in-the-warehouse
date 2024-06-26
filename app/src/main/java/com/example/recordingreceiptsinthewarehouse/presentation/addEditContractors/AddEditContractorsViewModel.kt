package com.example.recordingreceiptsinthewarehouse.presentation.addEditContractors

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recordingreceiptsinthewarehouse.domain.model.Contractor
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditContractorsViewModel @Inject constructor(
    private val repository: DocumentRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = MutableStateFlow(AddEditContractorsState())
    val state = _state.asStateFlow()

    fun onEvent(event: AddEditContractorsEvent) {
        when (event) {
            is AddEditContractorsEvent.EnteredName -> {
                _state.update { it.copy(
                    name = event.value
                ) }
            }
            is AddEditContractorsEvent.EnteredSymbol -> {
                _state.update { it.copy(
                    symbol = event.value
                ) }
            }
            AddEditContractorsEvent.SaveContractor -> {
                viewModelScope.launch {
                    repository.upsertContractor(Contractor(
                        id = _state.value.idContractor,
                        symbol = _state.value.symbol,
                        name = _state.value.name
                    ))
                }
            }
            is AddEditContractorsEvent.SetUpView -> {
                if (event.id >= 0) {
                    viewModelScope.launch {
                        val contractor = repository.getContractorById(event.id)

                        if (contractor != null) {
                            _state.update {
                                it.copy(
                                    idContractor = contractor.id,
                                    name = contractor.name,
                                    symbol = contractor.symbol
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}