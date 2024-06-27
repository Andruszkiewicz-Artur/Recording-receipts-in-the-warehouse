package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocumentPosition.comp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocumentPosition.AddEditDocumentPositionEvent
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocumentPosition.AddEditDocumentPositionViewModel
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold

@Composable
fun AddEditDocumentPositionPresentation(
    navHostController: NavHostController,
    idDocumentPosition: Long,
    idDocument: Long,
    viewModel: AddEditDocumentPositionViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = idDocumentPosition) {
        viewModel.onEvent(AddEditDocumentPositionEvent.SetUpView(idDocument, idDocumentPosition))
    }

    AppScaffold(
        title = if (idDocumentPosition >= 0) R.string.editDocumentPosition else R.string.addDocumentPosition,
        isNavigation = true,
        onClickNavigationButton = { navHostController.popBackStack() },
        actionButton = {
            TextButton(onClick = {
                viewModel.onEvent(AddEditDocumentPositionEvent.Save)
                navHostController.popBackStack()
            }) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    ) {
        OutlinedTextField(
            value = state.name,
            onValueChange = { viewModel.onEvent(AddEditDocumentPositionEvent.EnteredName(it)) },
            label = { Text(text = stringResource(id = R.string.name)) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = "${state.count}",
            onValueChange = { viewModel.onEvent(AddEditDocumentPositionEvent.EnteredCount(it)) },
            label = { Text(text = stringResource(id = R.string.count)) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = state.unitOfMeasure,
            onValueChange = { viewModel.onEvent(AddEditDocumentPositionEvent.EnteredUnit(it)) },
            label = { Text(text = stringResource(id = R.string.unit)) }
        )
    }
}