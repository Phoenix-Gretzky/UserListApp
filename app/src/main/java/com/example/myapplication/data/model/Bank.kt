package com.example.myapplication.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bank(
    @SerializedName("cardExpire")
    val cardExpire: String,
    @SerializedName("cardNumber")
    val cardNumber: String,
    @SerializedName("cardType")
    val cardType: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("iban")
    val iban: String
):Parcelable