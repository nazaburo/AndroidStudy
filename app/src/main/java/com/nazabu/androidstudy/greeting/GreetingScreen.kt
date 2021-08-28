package com.nazabu.androidstudy.greeting

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GreetingScreen(viewModel: GreetingViewModel = viewModel()) {
    val greeting = viewModel.greeting.observeAsState()

    greeting.value?.let {
        Text(text = "Hello $it")
    }
}
