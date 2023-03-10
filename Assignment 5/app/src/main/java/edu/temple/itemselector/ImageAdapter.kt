package edu.temple.itemselector

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(private val foodList: ArrayList<ImageItem>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>()
{
    var onImageClick : ((Int) -> Unit)? = null

    class ImageViewHolder(imageView: View) : RecyclerView.ViewHolder(imageView)
    {
        val imageView : ImageView = imageView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder
    {
        val imgView = LayoutInflater.from(parent.context).inflate(R.layout.image_display, parent, false)

        return ImageViewHolder(imgView)
    }

    override fun getItemCount(): Int
    {
        return foodList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int)
    {
        val image = foodList[position]

        Glide.with(holder.imageView.context)
            .load(image.image)
            .override(200, 200)
            .centerCrop()
            .into(holder.imageView)

        holder.imageView.setOnClickListener {
            onImageClick?.invoke(image.image)
        }
    }
}