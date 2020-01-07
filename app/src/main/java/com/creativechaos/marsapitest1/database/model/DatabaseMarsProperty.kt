package com.creativechaos.marsapitest1.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.creativechaos.marsapitest1.model.MarsProperty

@Entity(tableName = "mars_property")
data class DatabaseMarsProperty(@PrimaryKey val id: String,
                                val type: String,
                                val price: Double,
                                val imgSrcUrl: String)

fun List<DatabaseMarsProperty>.asMarsProperty(): List<MarsProperty>{
    return map{
        MarsProperty(id = it.id,
            type = it.type,
            price = it.price,
            imgSrcUrl = it.imgSrcUrl)
    }
}