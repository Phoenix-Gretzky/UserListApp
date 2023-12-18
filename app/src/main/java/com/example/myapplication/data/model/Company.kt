package com.example.myapplication.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
    @SerializedName("address")
    val address: Address,
    @SerializedName("department")
    val department: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String
) :Parcelable