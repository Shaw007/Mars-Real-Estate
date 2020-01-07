package com.creativechaos.marsapitest1.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.creativechaos.marsapitest1.database.model.DatabaseMarsProperty

@Dao
interface MarsPropertyDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(databaseMarsProperties: List<DatabaseMarsProperty>)

    @Query("select * from mars_property")
    fun getProperties() : LiveData<List<DatabaseMarsProperty>>
}