package com.example.recordingreceiptsinthewarehouse.presentation.documents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    repository: DocumentRepository
): ViewModel() {

    private val _state = MutableStateFlow(DocumentsState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllDocuments().collectLatest { documents ->
                _state.update { it.copy(
                    documents = documents
                ) }
            }
        }
    }
}