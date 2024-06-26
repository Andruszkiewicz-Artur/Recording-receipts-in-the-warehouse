package com.example.recordingreceiptsinthewarehouse.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.AppScaffold
import com.example.recordingreceiptsinthewarehouse.presentation.util.comp.BottomBarNavigation
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.NavGraph
import com.example.recordingreceiptsinthewarehouse.presentation.util.navigation.Screen
import com.example.recordingreceiptsinthewarehouse.presentation.util.theme.RecordingReceiptsInTheWarehouseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecordingReceiptsInTheWarehouseTheme {
                val navController = rememberNavController()

                NavGraph(navController = navController)
            }
        }
    }
}