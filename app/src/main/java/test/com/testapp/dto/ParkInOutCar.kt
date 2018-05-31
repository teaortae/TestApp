package test.com.testapp.dto

import com.google.gson.annotations.SerializedName

data class ParkInOutCar(
    @SerializedName("serialno") val serialno: String,
    @SerializedName("parkno") val parkno: Int,
    @SerializedName("incarno1") val incarno1: String,
    @SerializedName("indate") val indate: String,
    @SerializedName("fixedtype") val fixedtype: String,
    @SerializedName("inunitno") val inunitno: String,
    @SerializedName("inunitname") val inunitname: String,
    @SerializedName("carkind") val carkind: String,
    @SerializedName("inrecog") val inrecog: String
)