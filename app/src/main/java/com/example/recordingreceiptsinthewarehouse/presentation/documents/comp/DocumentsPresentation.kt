package com.example.recordingreceiptsinthewarehouse.presentation.documents.comp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NoteAdd
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
import java.util.Date

@Composable
fun DocumentsPresentation(
    navHostController: NavHostController,
    viewModel: DocumentsViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    AppScaffold(
        title = R.string.documents,
        floatingActionButton = Icons.Outlined.NoteAdd,
        onClickFloatingActionButton = { navHostController.navigate(Screen.AddEditDocument(-1)) },
        bottomBar = { BottomBarNavigation(navHostController = navHostController) }
    ) {
        LazyColumn {
            item {
                if (state.documents.isEmpty()) {
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

            items(state.documents) { document ->
                ListItem(
                    headlineContent = {
                        Text(text = document.symbol)
                    },
                    supportingContent = {
                        Text(text = "${Date(document.data)}")
                    }
                )
            }
        }
    }
}