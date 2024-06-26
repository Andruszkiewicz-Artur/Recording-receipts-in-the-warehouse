package com.example.recordingreceiptsinthewarehouse.presentation.documentDetails.comp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.Screen

@Composable
fun DocumentDetailsPresentation(
    navHostController: NavHostController
) {
    AppScaffold(
        title = R.string.documentDetails,
        isNavigation = true,
        onClickNavigationButton = { navHostController.popBackStack() },
        onClickFloatingActionButton = { navHostController.navigate(Screen.AddEditContractor(0)) }
    ) {

    }
}