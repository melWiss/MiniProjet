package com.elwiss.miniprojet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intentValue0 = intent.getStringExtra("Data0")
        val intentValue1 = intent.getStringExtra("Data1")
        val intentValue2 = intent.getStringExtra("Data2")
        val intentValue3 = intent.getStringExtra("Data3")
        val intentValue4 = intent.getStringExtra("Data4")
        val intentValue5 = intent.getStringExtra("Data5")

        /*
        Glide.with(context)
            .load(element.user.profile_image.large)//imageurl)
            .into(holder.imageView!!)
         */
        findViewById<ImageView>(R.id.photo_vertical_detail).apply {
            Glide.with(context)
                .load(intentValue0).into(findViewById(R.id.photo_vertical_detail))
        }
        findViewById<TextView>(R.id.userNameTextView).apply {
            text = intentValue1.toString()
        }
        findViewById<TextView>(R.id.smallDescTextView).apply {
            text = intentValue2.toString()
        }

        findViewById<TextView>(R.id.longDescTextView).apply {
            text = intentValue3.toString()
        }
        findViewById<TextView>(R.id.createAtTextView).apply {
            text = intentValue4.toString()
        }
        findViewById<TextView>(R.id.updateAtTextView).apply {
            text = intentValue5.toString()
        }


    }
}