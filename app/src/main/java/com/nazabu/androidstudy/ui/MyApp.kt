package com.nazabu.androidstudy.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nazabu.androidstudy.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@Composable
fun MyApp() {
    MyApplicationTheme {
        ProvideWindowInsets {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
            }

            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()

            val scaffoldState = rememberScaffoldState()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_ROUTE

            Scaffold(
                scaffoldState = scaffoldState,
                drawerContent = {
                    AppDrawer(
                        currentRoute = currentRoute,
                        navigateToHome = { navController.navigate(MainDestinations.HOME_ROUTE) },
                        navigateToAbout = { navController.navigate(MainDestinations.ABOUT) },
                        closeDrawer = { coroutineScope.launch { scaffoldState.drawerState.close() } }
                    )
                }
            ) {
                MyNavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}