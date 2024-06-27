package com.example.recordingreceiptsinthewarehouse.presentation.documentDetails

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DocumentDetailsViewModule @Inject constructor(
    private val repository: DocumentRepository
): ViewModel() {

    private val _state = MutableStateFlow(DocumentDetailsState())
    val state = _state.asStateFlow()

    fun onEvent(event: DocumentDetailsEvent) {
        when (event) {
            is DocumentDetailsEvent.SetUpView -> {
                if (event.id >= 0) {
                    viewModelScope.launch {
                        val document = repository.getDocumentWithContractorAndPositionsById(event.id)

                        _state.update { it.copy(
                            document = document
                        ) }
                    }
                }
            }
        }
    }
}