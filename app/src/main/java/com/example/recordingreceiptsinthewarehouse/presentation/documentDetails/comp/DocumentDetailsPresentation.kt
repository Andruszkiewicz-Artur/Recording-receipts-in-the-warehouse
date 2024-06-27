package com.example.recordingreceiptsinthewarehouse.presentation.documentDetails.comp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LibraryAdd
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.presentation.documentDetails.DocumentDetailsEvent
import com.example.recordingreceiptsinthewarehouse.presentation.documentDetails.DocumentDetailsViewModule
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.Screen
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DocumentDetailsPresentation(
    navHostController: NavHostController,
    idDocument: Long,
    viewModel: DocumentDetailsViewModule = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val formatter = SimpleDateFormat("dd MMM yyyy | HH:mm", Locale.getDefault())

    LaunchedEffect(key1 = idDocument) {
        viewModel.onEvent(DocumentDetailsEvent.SetUpView(idDocument))
    }

    AppScaffold(
        titleString = state.document.document.symbol,
        isNavigation = true,
        onClickNavigationButton = { navHostController.popBackStack() },
        floatingActionButton = Icons.Outlined.LibraryAdd,
        onClickFloatingActionButton = { navHostController.navigate(Screen.AddEditDocumentPosition(-1)) }
    ) {
        Text(text = formatter.format(Date(state.document.document.data)))
        Text(text = if (state.document.contractor != null) state.document.contractor.name + " | " + state.document.contractor.symbol else stringResource(id = R.string.nonContractor))

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(id = R.string.positions),
            fontWeight = FontWeight.Bold
        )

        LazyColumn {
            items(state.document.position) { position ->
                ListItem(
                    headlineContent = {
                        Text(text = position.name)
                    },
                    supportingContent = {
                        Text(text = "${position.count} ${position.unitOfMeasure}")
                    }
                )
            }
        }
    }
}