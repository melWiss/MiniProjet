package com.elwiss.miniprojet.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize



data class UnsplashLinks(
    val self: String,
    val html: String,
    val photos: String?,
    val likes: String?,
    val portfolio: String?,
    val download: String?,
    val download_location: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "UnsplashLinks(self='$self', html='$html', photos=$photos, likes=$likes, portfolio=$portfolio, download=$download, download_location=$download_location)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(self)
        parcel.writeString(html)
        parcel.writeString(photos)
        parcel.writeString(likes)
        parcel.writeString(portfolio)
        parcel.writeString(download)
        parcel.writeString(download_location)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnsplashLinks> {
        override fun createFromParcel(parcel: Parcel): UnsplashLinks {
            return UnsplashLinks(parcel)
        }

        override fun newArray(size: Int): Array<UnsplashLinks?> {
            return arrayOfNulls(size)
        }
    }
}
