package com.example.recordingreceiptsinthewarehouse.presentation.util.comp

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.Screen

@Composable
fun BottomBarNavigation(
    navHostController: NavHostController
) {
    val screens = listOf(
        Screen.DocumentsList,
        Screen.ContractorList
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val isBottomBar = screens.any { it == currentDestination }

    if (!isBottomBar) {
        BottomAppBar(

        ) {
            screens.forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy == screen,
                    onClick = {
                        navHostController.navigate(screen)
                    },
                    icon = {
                        Icon(
                            imageVector = if (screen == Screen.ContractorList) {
                                Icons.Outlined.Group
                            } else {
                                Icons.Outlined.Description
                            },
                            contentDescription = "navItem"
                        )
                    },
                    label = {
                        Text(
                            text = if (screen == Screen.ContractorList) {
                                stringResource(id = R.string.contractors)
                            } else {
                                stringResource(id = R.string.documents)
                            }
                        )
                    }
                )
            }
        }
    }
}