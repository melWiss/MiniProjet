package com.elwiss.miniprojet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class PictureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val intentValue = intent.getStringExtra("Data")
        findViewById<ImageView>(R.id.photo_horizontal_detail).apply{
            Glide.with(context)
                .load(intentValue).into(findViewById(R.id.photo_horizontal_detail))
        }
       /* Glide.with(context)
            .load(element.user.profile_image.large)//imageurl)
            .into(holder.imageView!!)
        */
    }
}