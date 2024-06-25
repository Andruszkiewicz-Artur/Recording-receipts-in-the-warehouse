package com.example.recordingreceiptsinthewarehouse.presentation.util.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Home> {

        }

        composable<Screen.DocumentsList> {

        }

        composable<Screen.DocumentsContractor> {

        }

        composable<Screen.DocumentPosition> {

        }

        composable<Screen.AddEditDocument> { backStackEntry ->
            val document = backStackEntry.toRoute<Screen.AddEditDocument>()

        }

        composable<Screen.AddEditContractor> { backStackEntry ->
            val document = backStackEntry.toRoute<Screen.AddEditContractor>()

        }

        composable<Screen.AddEditDocumentPosition> { backStackEntry ->
            val document = backStackEntry.toRoute<Screen.AddEditDocumentPosition>()

        }
    }

}