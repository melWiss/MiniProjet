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

class HeroesAdapter(
    private val unsplashPhotos: List<UnsplashPhoto>, private val context:
    Context
) : RecyclerView.Adapter<HeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HeroViewHolder {
        // Inflating R.layout.name_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return HeroViewHolder(view)
    }
    var itemClickListener: ((position: Int, name: String?) -> Unit)? = null
    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        // Getting element from names list at this position
        val element = unsplashPhotos[position]
        Glide.with(context)
            .load(element.user.profile_image.large)//imageurl)
            .into(holder.imageView!!)
        // Updating the text of the txtName with this element
        holder.textView?.text = element.user.username//.name//
        //holder.userNameView?.text=element.user.username
       // holder.creationDateView?.text=element.created_at
        holder.itemView.setOnClickListener {
            // Invoking itemClickListener and passing it the position and name
            itemClickListener?.invoke(position,
                element.user.profile_image.large)//.urls.large)
        }
    }

    override fun getItemCount(): Int {
        return unsplashPhotos.size
    }
}

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView? = itemView.findViewById(R.id.imageView)
    var textView: TextView? = itemView.findViewById(R.id.textView)

//var userNameView: TextView=itemView.findViewById(R.id.userName)
    //var creationDateView: TextView=itemView.findViewById(R.id.creationDate)

}
