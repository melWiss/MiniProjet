package com.elwiss.miniprojet.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UnsplashUrls(
    val thumb: String?,
    val small: String,
    val medium: String?,
    val regular: String?,
    val large: String?,
    val full: String?,
    val raw: String?

) :Parcelable {
    override fun toString(): String {
        return "UnsplashUrls(thumb=$thumb, small='$small', medium=$medium, regular=$regular, large=$large, full=$full, raw=$raw)"
    }
}
