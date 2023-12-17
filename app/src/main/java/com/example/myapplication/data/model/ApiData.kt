package com.example.myapplication.data.model


import com.google.gson.annotations.SerializedName

data class ApiData(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("users")
    val users: List<User>
)