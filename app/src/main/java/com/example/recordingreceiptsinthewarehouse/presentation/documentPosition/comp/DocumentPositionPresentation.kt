package com.example.recordingreceiptsinthewarehouse.presentation.documentPosition.comp

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.recordingreceiptsinthewarehouse.R
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold

@Composable
fun DocumentPositionPresentation(
    navHostController: NavHostController
) {
    AppScaffold(
        title = R.string.addContractor,
        isNavigation = true,
        onClickNavigationButton = { navHostController.popBackStack() },
        actionButton = {
            TextButton(onClick = {  }) {
                Text(text = stringResource(id = R.string.edit))
            }
        }
    ) {

    }
}