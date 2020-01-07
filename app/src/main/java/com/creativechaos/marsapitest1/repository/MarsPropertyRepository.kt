package com.creativechaos.marsapitest1.repository

import com.creativechaos.marsapitest1.database.MarsApiDatabase
import com.creativechaos.marsapitest1.database.model.DatabaseMarsProperty
import com.creativechaos.marsapitest1.network.MarsApi
import com.creativechaos.marsapitest1.network.model.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MarsPropertyRepository(val marsApiDatabase: MarsApiDatabase){

    val marsProperies = marsApiDatabase.marsPropertyDao.getProperties()

    suspend fun refreshMarsProperties(){
        withContext(Dispatchers.IO) {
            try {
                val marsProperties = MarsApi.retrofitService.getProperties().await()
                marsApiDatabase.marsPropertyDao.insert(marsProperties.asDatabaseModel())
            }catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }
}