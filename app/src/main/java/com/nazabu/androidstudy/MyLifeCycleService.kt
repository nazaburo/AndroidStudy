package com.nazabu.androidstudy

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleService
import timber.log.Timber

class MyLifeCycleService : LifecycleService() {
    private val observer: MyServiceObserver = MyServiceObserver()

    init {
        lifecycle.addObserver(observer)
    }
}

class MyServiceObserver : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        Timber.d("observe onCreate")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Timber.d("observe onDestroy")
    }
}