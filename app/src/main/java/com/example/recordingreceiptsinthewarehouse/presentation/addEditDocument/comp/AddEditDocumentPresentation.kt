package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument.comp

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument.AddEditDocumentEvent
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument.AddEditDocumentViewModel
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold

@Composable
fun AddEditDocumentPresentation(
    navHostController: NavHostController,
    viewModel: AddEditDocumentViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    AppScaffold(
        title = R.string.addDocument,
        isNavigation = true,
        onClickNavigationButton = { navHostController.popBackStack() },
        actionButton = {
            TextButton(onClick = {  }) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    ) {
        OutlinedTextField(
            value = state.symbol,
            onValueChange = { viewModel.onEvent(AddEditDocumentEvent.EnteredSymbol(it)) },
            label = {
                Text(text = stringResource(id = R.string.symbol))
            }
        )
    }
}