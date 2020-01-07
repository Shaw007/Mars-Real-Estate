package com.creativechaos.marsapitest1.ui.mars_property

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creativechaos.marsapitest1.database.MarsApiDatabase
import com.creativechaos.marsapitest1.database.model.asMarsProperty
import com.creativechaos.marsapitest1.model.MarsProperty
import com.creativechaos.marsapitest1.repository.MarsPropertyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MarsPropertyViewModel(application: Application): ViewModel(){
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val marsApiDatabase = MarsApiDatabase.getInstance(application)
    val marsPropertyRepository = MarsPropertyRepository(marsApiDatabase)

    val marsProperties: LiveData<List<MarsProperty>> = Transformations.map(marsPropertyRepository.marsProperies){
        it.asMarsProperty()
    }

    init {
        uiScope.launch {
            marsPropertyRepository.refreshMarsProperties()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}