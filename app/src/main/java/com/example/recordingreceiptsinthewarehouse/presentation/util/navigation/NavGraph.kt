package com.example.recordingreceiptsinthewarehouse.presentation.util.navigation

import android.annotation.SuppressLint
import android.util.Log
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
import com.example.recordingreceiptsinthewarehouse.presentation.addEditContractors.comp.AddEditContractorsPresentation
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocument.comp.AddEditDocumentPresentation
import com.example.recordingreceiptsinthewarehouse.presentation.addEditDocumentPosition.comp.AddEditDocumentPositionPresentation
import com.example.recordingreceiptsinthewarehouse.presentation.contractors.comp.ContractorsPresentation
import com.example.recordingreceiptsinthewarehouse.presentation.documentDetails.comp.DocumentDetailsPresentation
import com.example.recordingreceiptsinthewarehouse.presentation.documents.comp.DocumentsPresentation

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.DocumentsList
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.DocumentsList> {
            DocumentsPresentation(navHostController = navController)
        }

        composable<Screen.ContractorList> { backStackEntry ->
            val isMainPresentation = backStackEntry.toRoute<Screen.ContractorList>()

            ContractorsPresentation(
                navHostController = navController,
                isMainPresentation = isMainPresentation.isMainPresentation
            )
        }

        composable<Screen.DocumentDetails> { backStackEntry ->
            val document = backStackEntry.toRoute<Screen.DocumentDetails>()

            DocumentDetailsPresentation(
                navHostController = navController,
                idDocument = document.id
            )
        }

        composable<Screen.DocumentPosition> {

        }

        composable<Screen.AddEditDocument> { backStackEntry ->
            val document = backStackEntry.toRoute<Screen.AddEditDocument>()

            AddEditDocumentPresentation(
                navHostController = navController,
                documentId = document.id
            )
        }

        composable<Screen.AddEditContractor> { backStackEntry ->
            val contractor = backStackEntry.toRoute<Screen.AddEditContractor>()
            AddEditContractorsPresentation(
                navHostController = navController,
                idContractor = contractor.id
            )
        }

        composable<Screen.AddEditDocumentPosition> { backStackEntry ->
            val documentPosition = backStackEntry.toRoute<Screen.AddEditDocumentPosition>()

            AddEditDocumentPositionPresentation(
                navHostController = navController,
                idDocumentPosition = documentPosition.idDocumentPosition,
                idDocument = documentPosition.idDocument
            )
        }
    }

}