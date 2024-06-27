package com.example.recordingreceiptsinthewarehouse.presentation.documents.comp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.NoteAdd
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.domain.model.Document
import com.example.recordingreceiptsinthewarehouse.presentation.documents.DocumentsViewModel
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.BottomBarNavigation
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.Screen
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DocumentsPresentation(
    navHostController: NavHostController,
    viewModel: DocumentsViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val formatter = SimpleDateFormat("dd MMM yyyy | HH:mm", Locale.getDefault())

    AppScaffold(
        title = R.string.documents,
        floatingActionButton = Icons.Outlined.NoteAdd,
        onClickFloatingActionButton = { navHostController.navigate(Screen.AddEditDocument(-1)) },
        bottomBar = { BottomBarNavigation(navHostController = navHostController) }
    ) {
        LazyColumn {
            item {
                if (state.documentsWithContractors.isEmpty()) {
                    Text(
                        text = stringResource(id = R.string.dataNotYet),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    )
                }
            }

            items(state.documentsWithContractors) { document ->
                ListItem(
                    headlineContent = {
                        Text(text = document.document.symbol)
                    },
                    supportingContent = {
                        Column {
                            Text(text = if (document.contractor != null) document.contractor.name + " | " + document.contractor.symbol else stringResource(id = R.string.nonContractor))
                            Text(text = formatter.format(Date(document.document.data)))
                        }
                    },
                    trailingContent = {
                        Row {
                            IconButton(onClick = { navHostController.navigate(Screen.AddEditDocument(document.document.documentId ?: -1)) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    contentDescription = "edit"
                                )
                            }
                            IconButton(onClick = { viewModel.removeDocument(document.document) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Delete,
                                    contentDescription = "remove"
                                )
                            }
                        }
                    },
                    modifier = Modifier
                        .clickable { navHostController.navigate(Screen.DocumentDetails(document.document.documentId ?: -1)) }
                )

                if (state.documentsWithContractors.last() != document) {
                    HorizontalDivider()
                }
            }
        }
    }
}