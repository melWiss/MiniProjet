package com.elwiss.miniprojet.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class UnsplashUser(
    val id: String,
    val username: String,
    val name: String,
    val portfolio_url: String?,
    val bio: String?,
    val location: String?,
    val total_likes: Int,
    val total_photos: Int,
    val total_collection: Int,
    val profile_image: UnsplashUrls,
    val links: UnsplashLinks

) : Parcelable {
    override fun toString(): String {
        return "UnsplashUser(id='$id', username='$username', name='$name', portfolio_url=$portfolio_url, bio=$bio, location=$location, total_likes=$total_likes, total_photos=$total_photos, total_collection=$total_collection, profile_image=$profile_image, links=$links)"
    }
}
