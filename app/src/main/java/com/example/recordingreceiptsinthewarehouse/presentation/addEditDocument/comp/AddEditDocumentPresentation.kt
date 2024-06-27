package com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument.comp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument.AddEditDocumentEvent
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument.AddEditDocumentViewModel
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.Screen

@Composable
fun AddEditDocumentPresentation(
    navHostController: NavHostController,
    documentId: Long,
    viewModel: AddEditDocumentViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(AddEditDocumentEvent.SetUpDocument(documentId))
    }
    
    AppScaffold(
        title = R.string.addDocument,
        isNavigation = true,
        onClickNavigationButton = { navHostController.popBackStack() },
        actionButton = {
            TextButton(onClick = {
                viewModel.onEvent(AddEditDocumentEvent.SaveDocument)
                navHostController.popBackStack()
            }) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    ) {
        OutlinedTextField(
            value = state.document.symbol,
            onValueChange = { viewModel.onEvent(AddEditDocumentEvent.EnteredSymbol(it)) },
            label = {
                Text(text = stringResource(id = R.string.symbol))
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = state.contractor?.name ?: "",
            onValueChange = { },
            label = {
                Text(text = stringResource(id = R.string.contractor))
            },
            enabled = false,
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "find"
                )
            },
            modifier = Modifier
                .clickable {
                    navHostController.navigate(Screen.ContractorList(documentId))
                }
        )
    }
}