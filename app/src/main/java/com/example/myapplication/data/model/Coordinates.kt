package com.example.myapplication.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinates(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
) :Parcelable