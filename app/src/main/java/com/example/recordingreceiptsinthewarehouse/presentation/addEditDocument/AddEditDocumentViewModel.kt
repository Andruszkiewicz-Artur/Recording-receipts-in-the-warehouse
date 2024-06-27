package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recordingreceiptsinthewarehouse.domain.model.Document
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddEditDocumentViewModel @Inject constructor(
    private val repository: DocumentRepository
): ViewModel() {

    private val _state = MutableStateFlow(AddEditDocumentState())
    val state = _state.asStateFlow()

    fun onEvent(event: AddEditDocumentEvent) {
        when (event) {
            is AddEditDocumentEvent.EnteredSymbol -> {
                _state.update { it.copy(
                    document = it.document.copy(
                        symbol = event.value
                    )
                ) }
            }
            AddEditDocumentEvent.SaveDocument -> {
                viewModelScope.launch {
                    repository.upsertDocument(_state.value.document)
                }
            }
            is AddEditDocumentEvent.SetUpDocument -> {
                if (event.id >= 0) {
                    viewModelScope.launch {
                        repository.getDocumentWithContractorById(event.id).collectLatest { documentWithContractor ->
                            _state.update { it.copy(
                                document = documentWithContractor.document,
                                contractor = documentWithContractor.contractor
                            ) }
                        }
                    }
                }
            }
        }
    }
}