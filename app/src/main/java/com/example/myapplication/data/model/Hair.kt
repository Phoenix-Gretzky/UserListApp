package com.example.myapplication.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hair(
    @SerializedName("color")
    val color: String,
    @SerializedName("type")
    val type: String
):Parcelable