package com.example.recordingreceiptsinthewarehouse.presentation.util.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.recordingreceiptsinthewarehouse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    title: Int = 0,
    titleString: String? = null,
    bottomBar: @Composable () -> Unit = {  },
    isNavigation: Boolean = false,
    onClickNavigationButton: () -> Unit = {  },
    floatingActionButton: ImageVector? = null,
    onClickFloatingActionButton: () -> Unit = {  },
    actionButton: @Composable RowScope.() -> Unit = {  },
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (title != 0 || titleString != null) {
                CenterAlignedTopAppBar(
                    actions = {
                        actionButton()
                    },
                    title = {
                        Column {
                            Text(text = titleString ?: stringResource(id = title))
                        }
                    },
                    navigationIcon = {
                        if (isNavigation) {
                            IconButton(onClick = { onClickNavigationButton() }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "BackButton"
                                )
                            }
                        }
                    }
                )
            }
        },
        bottomBar = {
            bottomBar()
        },
        floatingActionButton = {
            if (floatingActionButton != null) {
                FloatingActionButton(onClick = { onClickFloatingActionButton() }) {
                    Icon(
                        imageVector = floatingActionButton,
                        contentDescription = "Add"
                    )
                }
            }
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 12.dp)
        ) {
            content()
        }
    }
}