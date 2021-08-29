package com.nazabu.androidstudy.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nazabu.androidstudy.about.AboutScreen
import com.nazabu.androidstudy.greeting.GreetingScreen
import com.nazabu.androidstudy.greeting.GreetingViewModel
import kotlinx.coroutines.launch

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val ABOUT = "about"
}

@Composable
fun MyNavGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MainDestinations.HOME_ROUTE
) {
    val coroutineScope = rememberCoroutineScope()
    val openDrawer: () -> Unit = { coroutineScope.launch { scaffoldState.drawerState.open() } }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            val viewModel = hiltViewModel<GreetingViewModel>()
            GreetingScreen(
                viewModel,
                openDrawer
            )
        }

        composable(MainDestinations.ABOUT) {
            AboutScreen(
                openDrawer
            )
        }


    }

}
