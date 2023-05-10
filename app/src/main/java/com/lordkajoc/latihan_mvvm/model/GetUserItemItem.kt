package com.lordkajoc.latihan_mvvm.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetUserItemItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
): Serializable