package com.example.recordingreceiptsinthewarehouse.presentation.addEditContractors.comp

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
import com.example.recordingreceiptsinthewarehouse.presentation.addEditContractors.AddEditContractorsEvent
import com.example.recordingreceiptsinthewarehouse.presentation.addEditContractors.AddEditContractorsViewModel
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold

@Composable
fun AddEditContractorsPresentation(
    navHostController: NavHostController,
    viewModel: AddEditContractorsViewModel = hiltViewModel(),
    idContractor: Long
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(AddEditContractorsEvent.SetUpView(idContractor))
    }

    AppScaffold(
        title = R.string.addContractor,
        isNavigation = true,
        onClickNavigationButton = { navHostController.popBackStack() },
        actionButton = {
            TextButton(onClick = {
                viewModel.onEvent(AddEditContractorsEvent.SaveContractor)
                navHostController.popBackStack()
            }) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    ) {
        OutlinedTextField(
            value = state.name,
            onValueChange = { viewModel.onEvent(AddEditContractorsEvent.EnteredName(it)) },
            label = { Text(text = stringResource(id = R.string.name)) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = state.symbol,
            onValueChange = { viewModel.onEvent(AddEditContractorsEvent.EnteredSymbol(it)) },
            label = { Text(text = stringResource(id = R.string.symbol)) }
        )
    }
}