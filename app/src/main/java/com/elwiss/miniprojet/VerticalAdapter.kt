package com.elwiss.miniprojet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elwiss.miniprojet.models.UnsplashPhoto

class VerticalAdapter(
    private val unsplashPhotos: List<UnsplashPhoto>, private val context:
    Context
) : RecyclerView.Adapter<VerticalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            VerticalViewHolder {
        // Inflating R.layout.name_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return VerticalViewHolder(view)
    }

    var itemClickListener: ((position: Int, photo: String?, name: String, smallDesc: String, longDesc: String, createAt: String, updateAt: String) -> Unit)? =
        null

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        // Getting element from names list at this position
        val element = unsplashPhotos[position]
        Glide.with(context)
            .load(element.user.profile_image.large)//imageurl)
            .into(holder.imageView!!)
        // Updating the text of the txtName with this element
        holder.textView?.text = element.user.username//.name//
        //holder.userNameView?.text=element.user.username
        holder.creationDateView?.text = element.created_at
        holder.itemView.setOnClickListener {
            // Invoking itemClickListener and passing it the position and name

            itemClickListener?.invoke(
                position,
                element.user.profile_image.large,
                element.user.username,
                element.id,
                element.user.id,
                element.updated_at,
                element.created_at
            )
        }
    }

    override fun getItemCount(): Int {
        return unsplashPhotos.size
    }
}

class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView? = itemView.findViewById(R.id.item_photo_iv)
    var textView: TextView? = itemView.findViewById(R.id.userName)
    var creationDateView: TextView? = itemView.findViewById(R.id.creationDate)

//var userNameView: TextView=itemView.findViewById(R.id.userName)

}
