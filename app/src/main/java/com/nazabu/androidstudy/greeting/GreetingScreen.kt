package com.nazabu.androidstudy.greeting

import android.content.res.Configuration
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nazabu.androidstudy.R
import com.nazabu.androidstudy.ui.components.InsetAwareTopAppBar
import com.nazabu.androidstudy.ui.theme.MyApplicationTheme

@Composable
fun GreetingScreen(
    viewModel: GreetingViewModel = viewModel(),
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val greeting = viewModel.greeting.observeAsState()

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
        man?.let {
            Text(text = "Hello $it")
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