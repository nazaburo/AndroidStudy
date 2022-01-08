package com.nazabu.androidstudy.greeting

import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nazabu.androidstudy.MyLifeCycleService
import com.nazabu.androidstudy.R
import com.nazabu.androidstudy.ui.components.InsetAwareTopAppBar
import com.nazabu.androidstudy.ui.theme.MyApplicationTheme

@Composable
fun GreetingScreen(
    viewModel: GreetingViewModel = viewModel(),
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val greeting = viewModel.greeting.collectAsState()

    GreetingScreen(
        man = greeting.value,
        openDrawer = openDrawer,
        scaffoldState = scaffoldState
    )
}

@Composable
fun GreetingScreen(
    man: String?,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState
) {
    val context = LocalContext.current
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            val title = stringResource(id = R.string.app_name)
            InsetAwareTopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(onClick = openDrawer) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            man?.let {
                Text(text = "Hello $it")
            }
            Button(onClick = {
                context.startService(Intent(context, MyLifeCycleService::class.java))
            }) {
                Text(text = "start service")
            }
            Button(onClick = {
                context.stopService(Intent(context, MyLifeCycleService::class.java))
            }) {
                Text(text = "stop service")
            }
        }
    }
}

@Preview("Home screen")
@Preview("Home screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("Home screen (big font)", fontScale = 1.5f)
@Preview("Home screen (large screen)", device = Devices.PIXEL_C)
@Composable
fun ReviewGreetingScreen() {
    MyApplicationTheme {
        GreetingScreen(
            man = "nazaburo",
            openDrawer = {},
            scaffoldState = rememberScaffoldState()
        )
    }
}