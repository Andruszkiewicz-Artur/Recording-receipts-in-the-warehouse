package com.example.recordingreceiptsinthewarehouse.presentation.contractors.comp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.PersonAdd
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
import com.example.recordingreceiptsinthewarehouse.presentation.contractors.ContractorsViewModel
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.BottomBarNavigation
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.Screen
import java.util.Date

@Composable
fun ContractorsPresentation(
    navHostController: NavHostController,
    isMainPresentation: Boolean,
    viewModel: ContractorsViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    AppScaffold(
        isNavigation = !isMainPresentation,
        onClickNavigationButton = { navHostController.popBackStack() },
        title = R.string.contractors,
        floatingActionButton = Icons.Outlined.PersonAdd,
        onClickFloatingActionButton = { navHostController.navigate(Screen.AddEditContractor(-1)) },
        bottomBar = { if (isMainPresentation) {
            BottomBarNavigation(navHostController = navHostController)
        } }
    ) {
        LazyColumn {
            item {
                if (state.contractors.isEmpty()) {
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

            items(state.contractors) { contractor ->
                ListItem(
                    headlineContent = {
                        Text(text = contractor.name)
                    },
                    supportingContent = {
                        Text(text = contractor.symbol)
                    },
                    leadingContent = {
                        if (!isMainPresentation) {
                            IconButton(onClick = {
                                navHostController.previousBackStackEntry?.savedStateHandle?.set("idContractor", contractor.id ?: -1)
                                navHostController.popBackStack()
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Add,
                                    contentDescription = "add"
                                )
                            }
                        }
                    },
                    trailingContent = {
                        Row {
                            IconButton(onClick = { navHostController.navigate(Screen.AddEditContractor(contractor.id ?: -1)) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    contentDescription = "edit"
                                )
                            }
                            IconButton(onClick = { viewModel.removeContractor(contractor) }) {
                                Icon(
                                    imageVector = Icons.Outlined.Delete,
                                    contentDescription = "remove"
                                )
                            }
                        }
                    }
                )

                if (contractor != state.contractors.last()) {
                    HorizontalDivider()
                }
            }
        }
    }
}