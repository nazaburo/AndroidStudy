package com.nazabu.androidstudy.greeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor(
) : ViewModel() {
    val greeting: LiveData<String> = MutableLiveData("compose!!")
}
