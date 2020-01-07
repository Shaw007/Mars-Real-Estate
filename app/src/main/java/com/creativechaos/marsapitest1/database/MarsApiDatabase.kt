package com.creativechaos.marsapitest1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.creativechaos.marsapitest1.database.dao.MarsPropertyDao
import com.creativechaos.marsapitest1.database.model.DatabaseMarsProperty
import com.creativechaos.marsapitest1.util.Constants

@Database(entities = [DatabaseMarsProperty::class], version = 1)
abstract class MarsApiDatabase: RoomDatabase(){

    abstract val marsPropertyDao: MarsPropertyDao

    companion object{
        private lateinit var INSTANCE: MarsApiDatabase

        fun getInstance(context: Context): MarsApiDatabase{
            if(!::INSTANCE.isInitialized){
                INSTANCE = Room.databaseBuilder(context,
                    MarsApiDatabase::class.java,
                    Constants.ROOM_DATABASE_NAME)
                    .build()
            }
            return INSTANCE
        }
    }
}