package com.creativechaos.marsapitest1.network.model

import com.creativechaos.marsapitest1.database.model.DatabaseMarsProperty
import com.squareup.moshi.Json

data class NetworkMarsProperty(val id: String,
                               val type: String,
                               val price: Double,
                               @Json(name="img_src") val imgSrcUrl: String)

fun List<NetworkMarsProperty>.asDatabaseModel(): List<DatabaseMarsProperty>{
    return map{
        DatabaseMarsProperty(id = it.id,
            type = it.type,
            price = it.price,
            imgSrcUrl = it.imgSrcUrl)
    }
}