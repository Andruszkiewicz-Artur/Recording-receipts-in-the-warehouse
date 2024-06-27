package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocumentPosition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recordingreceiptsinthewarehouse.domain.model.DocumentPosition
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditDocumentPositionViewModel @Inject constructor(
    private val repository: DocumentRepository
): ViewModel() {

    private val _state = MutableStateFlow(DocumentPosition(
        positionId = null,
        documentOwnId = -1,
        name = "",
        count = 0f,
        unitOfMeasure = ""
    ))
    val state = _state.asStateFlow()

    fun onEvent(event: AddEditDocumentPositionEvent) {
        when (event) {
            is AddEditDocumentPositionEvent.EnteredCount -> {
                _state.update { it.copy(
                    count = event.value.toFloatOrNull() ?: 0f
                ) }
            }
            is AddEditDocumentPositionEvent.EnteredName -> {
                _state.update { it.copy(
                    name = event.value
                ) }
            }
            is AddEditDocumentPositionEvent.EnteredUnit -> {
                _state.update { it.copy(
                    unitOfMeasure = event.value
                ) }
            }
            AddEditDocumentPositionEvent.Save -> {
                viewModelScope.launch {
                    repository.upsertDocumentPosition(documentPosition = state.value)
                }
            }
            is AddEditDocumentPositionEvent.SetUpView -> {
                if (event.idDocumentPosition >= 0) {
                    viewModelScope.launch {
                        _state.update { repository.getDocumentPositionById(documentPositionId = event.idDocumentPosition) }
                    }
                } else {
                    _state.update { it.copy(
                        documentOwnId = event.idDocument
                    ) }
                }
            }
        }
    }

}