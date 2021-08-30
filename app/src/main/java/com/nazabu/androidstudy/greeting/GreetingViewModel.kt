package com.nazabu.androidstudy.greeting

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor(
) : ViewModel() {

    private val _greeting = MutableStateFlow("compose!!")
    val greeting: StateFlow<String> = _greeting.asStateFlow()
}
