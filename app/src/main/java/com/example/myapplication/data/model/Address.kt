package com.example.myapplication.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("coordinates")
    val coordinates: Coordinates,
    @SerializedName("postalCode")
    val postalCode: String,
    @SerializedName("state")
    val state: String
) : Parcelable