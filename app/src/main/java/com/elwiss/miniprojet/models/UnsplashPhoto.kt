package com.elwiss.miniprojet.models





data class UnsplashPhoto(


    val id: String,
    val created_at: String,
    val updated_at: String,
    val width: Int,
    val height: Int,
    val color: String? = "#000000",
    val likes: Int,
    val description: String?,
    val urls: UnsplashUrls,
    val links: UnsplashLinks,
    val user: UnsplashUser

) {
    /*override fun toString(): String {
        return "Hero(name=$name, realname=$realname, team=$team, firstappearance=$firstappearance, createdby=$createdby, publisher=$publisher, imageurl=$imageurl, bio=$bio)"
    }*/
    override fun toString(): String {
        return "Hero(id='$id', created_at='$created_at', width=$width, height=$height, color=$color, likes=$likes, description=$description, urls=$urls, links=$links, user=$user)"
    }
}


