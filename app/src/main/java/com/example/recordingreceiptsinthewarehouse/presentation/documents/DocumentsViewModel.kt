package com.example.recordingreceiptsinthewarehouse.presentation.documents

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
import javax.inject.Inject

@HiltViewModel
class DocumentsViewModel @Inject constructor(
    private val repository: DocumentRepository
): ViewModel() {

    private val _state = MutableStateFlow(DocumentsState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllDocumentWithContractor().collectLatest { documentsWithContractors ->
                _state.update { it.copy(
                    documentsWithContractors = documentsWithContractors
                ) }
            }
        }
    }

    fun removeDocument(document: Document) {
        viewModelScope.launch {
            repository.deleteDocument(document)
        }
    }
}