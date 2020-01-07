package com.creativechaos.marsapitest1.ui.mars_property

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MarsPropertyViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarsPropertyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MarsPropertyViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}