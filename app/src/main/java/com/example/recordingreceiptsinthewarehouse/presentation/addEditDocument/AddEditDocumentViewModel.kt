package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument

import androidx.lifecycle.ViewModel
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
                    symbol = event.value
                ) }
            }
            AddEditDocumentEvent.SaveDocument -> {

            }
        }
    }
}