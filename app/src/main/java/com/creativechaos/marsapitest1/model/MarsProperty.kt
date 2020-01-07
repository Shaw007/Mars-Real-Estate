package com.creativechaos.marsapitest1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarsProperty(val id: String,
                        val type: String,
                        val price: Double,
                        val imgSrcUrl: String) : Parcelable